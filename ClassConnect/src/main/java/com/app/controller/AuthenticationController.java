package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthenticationRequest;
import com.app.dto.AuthenticationResponse;
import com.app.pojos.Admin;
import com.app.pojos.Student;
import com.app.pojos.Tutor;
import com.app.service.AuthenticationService;
import com.app.service.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
	@Autowired
	private final AuthenticationService service;
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/register/student")
	public ResponseEntity<AuthenticationResponse> registerNewStudent(@RequestBody Student request){
		return ResponseEntity.ok(service.registerStudent(request));	
	}
	
	@PostMapping("/register/tutor")
	public ResponseEntity<AuthenticationResponse> registerNewTutor(@RequestBody Tutor request){
		return ResponseEntity.ok(service.registerTutor(request));
	}
	
	@PostMapping("/register/admin")
	public ResponseEntity<AuthenticationResponse> registerNewAdmin(@RequestBody Admin request){
		System.out.println("EmailID iS controller : " + request.getEmailId());
		return ResponseEntity.ok(service.registerAdmin(request));	
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
		System.out.println(request);
		return ResponseEntity.ok(service.authenticate(request));
	}
	
	@GetMapping("/authenticate/getlogin/{emailId}")
	public ResponseEntity<?> findByEmailId(@PathVariable String emailId){
		return ResponseEntity.ok(loginService.findByEmailId(emailId));
	}
}