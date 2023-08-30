package com.app.service;

import com.app.pojos.StudentEducationalDetails;

public interface StudentEduDetailsService {

	String addStudentEducationalDetails(Long studentId, StudentEducationalDetails request);
	
}
