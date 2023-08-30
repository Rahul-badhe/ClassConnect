package com.app.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.pojos.Tutor;

public interface TutorService {
	Tutor findTutorByEmail(String email);
}
