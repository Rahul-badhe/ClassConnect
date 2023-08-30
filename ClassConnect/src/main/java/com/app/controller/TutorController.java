package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Address;
import com.app.pojos.Tutor;
import com.app.pojos.TutorExperience;
import com.app.pojos.TutorQualifications;
import com.app.service.AddressService;
import com.app.service.TutorExperienceService;
import com.app.service.TutorQualificationsService;
import com.app.service.TutorService;

@RestController
@RequestMapping("/tutor")
@CrossOrigin
public class TutorController {
	
	@Autowired
	private TutorQualificationsService tutorQualificationsService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private TutorExperienceService tutorExperienceService;
	
	@Autowired
	private TutorService tutorService;
	
	@PostMapping("/qualificationdetails/{tutorId}")
	public ResponseEntity<?> addTutorQualifications
	(@PathVariable Long tutorId, @RequestBody TutorQualifications tutorQualifications){
		return ResponseEntity.ok(tutorQualificationsService.addTutorQualifications(tutorId,tutorQualifications));
	}
	
	@PostMapping("/address/{tutorId}")
	public ResponseEntity<?> addTutorAddress
	(@PathVariable Long tutorId, @RequestBody Address address){
		System.out.println(tutorId);
		System.out.println(address);
		return ResponseEntity.ok(addressService.addTutorAddress(tutorId,address));
	}
	
	@PostMapping("/experience/{tutorId}")
	public ResponseEntity<?> addTutorExperience
	(@PathVariable Long tutorId, @RequestBody TutorExperience tutorExperience){
		System.out.println(tutorId);
		System.out.println(tutorExperience);
		return ResponseEntity.ok(tutorExperienceService.addTutorExperience(tutorId,tutorExperience));
	}
	
	@GetMapping("/detailsbyemail/{email}")
	public ResponseEntity<?> findTutorByEmail(@PathVariable String email){
		return ResponseEntity.ok(tutorService.findTutorByEmail(email));
	}

}