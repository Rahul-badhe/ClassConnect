package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.CourseBrochure;
import com.app.repository.CourseBrochureRepository;
import com.app.service.CourseBrochureService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseBrochureService courseBrochureService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCourse(@RequestParam Long tutorId,@RequestBody CourseBrochure newCourse){
		return ResponseEntity.ok(courseBrochureService.addCourse(tutorId, newCourse));
	}
}
