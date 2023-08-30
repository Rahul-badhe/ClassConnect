package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ResourceNotFoundException;
import com.app.pojos.Address;
import com.app.pojos.CourseEnrollment;
import com.app.pojos.Student;
import com.app.pojos.StudentEducationalDetails;
import com.app.service.AddressService;
import com.app.service.StudentEduDetailsService;
import com.app.service.StudentService;
import com.app.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	@Autowired
	private StudentService studService;
	
	@Autowired
	private StudentEduDetailsService detailsService;
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/edudetails/{studentId}")
	public ResponseEntity<?> addStudentEducationalDetails
	(@PathVariable Long studentId, @RequestBody StudentEducationalDetails request){
		System.out.println(studentId);
		System.out.println(request);
		return ResponseEntity.ok(detailsService.addStudentEducationalDetails(studentId,request));
	}
	
	@PostMapping("/address/{studentId}")
	public ResponseEntity<?> addStudentAddress
	(@PathVariable Long studentId, @RequestBody Address address){
		System.out.println(studentId);
		System.out.println(address);
		return ResponseEntity.ok(addressService.addStudentAddress(studentId,address));
	}
	
	@PostMapping("/enroll")
	public ResponseEntity<?> addEnrollment
	(@RequestParam Long studentId,@RequestParam Long courseId, @RequestBody CourseEnrollment newCourseEnrollment){
		return ResponseEntity.ok(studService.addEnrollment(studentId, courseId, newCourseEnrollment));
	}
	
	@GetMapping("/{studentId}")
	@ResponseBody
	public Student getStudentDetails(@PathVariable Long studentId) {
		System.out.println(studentId);
		// invoke service layer method to get emp details
		return studService.getStudentDetails(studentId);
	}

	@PutMapping
	public ResponseEntity<?> updateStudentDetails(@RequestBody Student detachedStudent) throws ResourceNotFoundException {
		System.out.println(detachedStudent.getStudentId());// not null
		return ResponseEntity.ok(studService.updateStudentDetails(detachedStudent));
	}
	

	@GetMapping("/detailsbyemail/{emailId}")
	@ResponseBody
	public ResponseEntity<?> getStudentDetails(@PathVariable String emailId) {
		return ResponseEntity.ok(studService.getStudentDetails(emailId));
	}

}