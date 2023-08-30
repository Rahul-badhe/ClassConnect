package com.app.service;

import com.app.exception.ResourceNotFoundException;
import com.app.pojos.CourseEnrollment;
import com.app.pojos.Student;

public interface StudentService {
	 
	String addEnrollment(Long studentId, Long courseId, CourseEnrollment newCourseEnrollment);

	Student getStudentDetails(Long studentId);

	Student updateStudentDetails(Student detachedStudent) throws ResourceNotFoundException;
	
	Student getStudentDetails(String emailId);

}
