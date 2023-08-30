package com.app.service;

import java.util.Optional;

import com.app.pojos.Login;

public interface LoginService {
	Optional<Login> findByEmailId(String emailId);
}
