package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.CourseBrochureService;

@RestController
public class HomeController {
	@Autowired
	CourseBrochureService courseBrochureService;
	
	//if search by stream,sub,level
	@GetMapping("/search_ssl")
	public ResponseEntity<?> searchTutors(
			@RequestParam String stream,
			@RequestParam String courseName,
			@RequestParam String level){
		System.out.println(stream+" " +courseName+" "+level);
		return ResponseEntity.ok(courseBrochureService.findCoursesBySSL(stream,courseName,level));
	}
	
	@GetMapping("/search_keyword")
	public ResponseEntity<?> searchTutors(
			@RequestParam String keyword){
		System.out.println(keyword);
		return ResponseEntity.ok(courseBrochureService.findCoursesByKeyword(keyword));
	}
}
