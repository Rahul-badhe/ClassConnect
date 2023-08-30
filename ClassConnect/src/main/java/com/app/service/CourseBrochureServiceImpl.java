package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.CourseBrochure;
import com.app.pojos.Tutor;
import com.app.repository.CourseBrochureRepository;
import com.app.repository.TutorRepository;

@Service
@Transactional
public class CourseBrochureServiceImpl implements CourseBrochureService{
	@Autowired
	private CourseBrochureRepository courseBrochureRepository;
	
	@Autowired
	private TutorRepository tutorRepository;

	@Override
	public List<CourseBrochure> findCoursesBySSL(String stream, String courseName, String level) {
		return courseBrochureRepository.findByStreamAndCourseNameAndLevel(stream, courseName, level);
	}

	@Override
	public List<CourseBrochure> findCoursesByKeyword(String keyword) {
		List<CourseBrochure> courseBrochureList=new ArrayList<CourseBrochure>();
		courseBrochureList.addAll(courseBrochureRepository.findByStream(keyword));
		courseBrochureList.addAll(courseBrochureRepository.findByCourseName(keyword));
		courseBrochureList.addAll(courseBrochureRepository.findByLevel(keyword));
		return courseBrochureList;
	}

	@Override
	public String addCourse(Long tutorId, CourseBrochure newCourse) {
		Tutor existingTutor = tutorRepository.findById(tutorId).orElseThrow();
		existingTutor.addCourseBrochure(newCourse);
		courseBrochureRepository.save(newCourse);
		return "Course added succesfully";
	}

}
