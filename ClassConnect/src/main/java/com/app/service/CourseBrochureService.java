package com.app.service;

import java.util.List;

import com.app.pojos.CourseBrochure;

public interface CourseBrochureService{

	List<CourseBrochure> findCoursesBySSL(String stream, String courseName, String level);

	List<CourseBrochure> findCoursesByKeyword(String keyword);
	
	String addCourse(Long tutorId, CourseBrochure newCourse);
}
