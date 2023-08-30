package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.StudentEduDetailsDto;
import com.app.pojos.Student;
import com.app.pojos.StudentEducationalDetails;
import com.app.repository.StudentEduDetailsRepository;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentEduDetailsServiceImpl implements StudentEduDetailsService {
	@Autowired
	private StudentEduDetailsRepository detailsRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public String addStudentEducationalDetails(Long studentId, StudentEducationalDetails request) {
		Student existingStudent = studentRepository.findById(studentId).orElseThrow();
		request.addStudent(existingStudent);
		detailsRepository.save(request);
		return "Student Educational Details succesfully";
	}
	
	
}
