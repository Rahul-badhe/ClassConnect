package com.app.service;

import com.app.pojos.Address;

public interface AddressService {

	String addStudentAddress(Long studentId, Address address);
	
	String addTutorAddress(Long tutorId, Address address);
	
	
}
