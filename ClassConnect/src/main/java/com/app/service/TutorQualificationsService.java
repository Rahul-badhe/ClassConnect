package com.app.service;

import org.springframework.http.ResponseEntity;

import com.app.pojos.TutorQualifications;

public interface TutorQualificationsService {
	
	String addTutorQualifications(Long tutorId, TutorQualifications tutorQualifications); 
}
