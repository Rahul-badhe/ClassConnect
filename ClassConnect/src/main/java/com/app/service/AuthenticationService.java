package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.AuthenticationRequest;
import com.app.dto.AuthenticationResponse;
import com.app.dto.StudentDto;
import com.app.pojos.Admin;
import com.app.pojos.Login;
import com.app.pojos.Student;
import com.app.pojos.Token;
import com.app.pojos.TokenType;
import com.app.pojos.Tutor;
import com.app.pojos.User;
import com.app.pojos.UserRoles;
import com.app.repository.AdminRepository;
import com.app.repository.LoginRepository;
import com.app.repository.StudentRepository;
import com.app.repository.TokenRepository;
import com.app.repository.TutorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	@Autowired
	private final StudentRepository studentRepository;
	@Autowired
	private final AdminRepository adminRepository;
	private final LoginRepository loginRepository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final TokenRepository tokenRepository;
	private final TutorRepository tutorRepository;

	// String firstName, String lastName, String mobileNo, String emailId, String
	// password,
	// String gender,
	// byte[] profilePhoto, byte[] idProof, LocalDate dob

	public AuthenticationResponse registerStudent(Student request) {
		String passwd = passwordEncoder.encode(request.getPassword());
		Student student = new Student(request.getFirstName(), request.getLastName(), request.getMobileNo(),
				request.getEmailId(), passwd, request.getGender(),
				request.getDob());
		Login newLogin = new Login(request.getEmailId(), passwd, UserRoles.ROLE_STUDENT);
		student.addLogin(newLogin);
		loginRepository.save(newLogin);
		studentRepository.save(student);
		var jwtToken = jwtService.generateToken(newLogin);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}
	
	public AuthenticationResponse registerTutor(Tutor request) {
		String passwd = passwordEncoder.encode(request.getPassword());
		Tutor tutor = new Tutor(request.getFirstName(), request.getLastName(), request.getMobileNo(),
				request.getEmailId(), passwd, request.getGender(),
				request.getDob(),request.getTagline(),request.getSummary(),request.getTotalExperience());
		Login newLogin = new Login(request.getEmailId(), passwd, UserRoles.ROLE_TUTOR);
		tutor.addLogin(newLogin);
		tutorRepository.save(tutor);
		loginRepository.save(newLogin);
		var jwtToken = jwtService.generateToken(newLogin);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}
	
	public AuthenticationResponse registerAdmin(Admin request) {
		String passwd = passwordEncoder.encode(request.getPassword());
		System.out.println("EmailID iS11 : " + request.getEmailId());
		Admin admin = new Admin(request.getFirstName(), request.getLastName(), request.getMobileNo(),
				request.getEmailId(), passwd, request.getGender(),
				request.getDob());
		admin.setEmailId(request.getEmailId());
		admin.setPassword(request.getPassword());
		System.out.println("EmailID iS15 : " + request.getEmailId());
		Login newLogin = new Login(request.getEmailId(), passwd, UserRoles.ROLE_ADMIN);
		admin.addLogin(newLogin);
		System.out.println("EmailID iS16 : " + newLogin.toString());
		loginRepository.save(newLogin);
		System.out.println("EmailID iS17 : " + request.getEmailId());
		adminRepository.save(admin);
		System.out.println("EmailID iS22 : " + request.getEmailId());
		var jwtToken = jwtService.generateToken(newLogin);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		String emailId = request.getEmailId();
		authenticationManager
				.authenticate(
						new UsernamePasswordAuthenticationToken(
								request.getEmailId(), 
								request.getPassword()
								)
							);
		var login = loginRepository.findByEmailId(emailId).orElseThrow();
		var jwtToken = jwtService.generateToken(login);
		revokeAllUserTokens(login);
		saveUserToken(login, jwtToken);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	private void saveUserToken(Login login, String jwtToken) {
		var token = Token.builder().login(login).token(jwtToken).tokenType(TokenType.BEARER).expired(false)
				.revoked(false).build();
		tokenRepository.save(token);
	}

	private void revokeAllUserTokens(Login login) {
		var validUserTokens = tokenRepository.findAllValidTokenByLogin(login.getLoginId());
		if (validUserTokens.isEmpty())
			return;
		validUserTokens.forEach(token -> {
			token.setExpired(true);
			token.setRevoked(true);
		});
		tokenRepository.saveAll(validUserTokens);
	}

}
