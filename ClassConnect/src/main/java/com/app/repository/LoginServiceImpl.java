package com.app.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Login;
import com.app.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public Optional<Login> findByEmailId(String emailId) {
		Optional<Login> existingLogin = loginRepository.findByEmailId(emailId);
		return existingLogin;
	}

}
