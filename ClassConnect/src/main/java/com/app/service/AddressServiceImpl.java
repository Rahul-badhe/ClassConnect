package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Address;
import com.app.pojos.Student;
import com.app.pojos.Tutor;
import com.app.repository.AddressRepository;
import com.app.repository.StudentRepository;
import com.app.repository.TutorRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private TutorRepository tutorRepository;
	
	@Override
	public String addStudentAddress(Long studentId, Address address) {
		Student existingStudent=studentRepository.findById(studentId).orElseThrow();
		addressRepository.save(address);
		existingStudent.addAddress(address);
		return "Address added successfully...";
	}
	
	@Override
	public String addTutorAddress(Long tutorId, Address address) {
		Tutor existingTutor=tutorRepository.findById(tutorId).orElseThrow();
		addressRepository.save(address);
		existingTutor.addAddress(address);
		return "Address added successfully...";
	}

}
