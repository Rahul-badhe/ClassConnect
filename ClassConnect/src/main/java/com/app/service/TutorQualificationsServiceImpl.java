package com.app.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.pojos.Tutor;
import com.app.pojos.TutorQualifications;
import com.app.repository.TutorQualificationRepository;
import com.app.repository.TutorRepository;


@Service
@Transactional
class TutorQualificationsServiceImpl implements TutorQualificationsService {
	@Autowired
	private TutorQualificationRepository tutorQualificationRepository;
	@Autowired
	private TutorRepository tutorRepository;

	@Override
	public String addTutorQualifications(Long tutorId, TutorQualifications tutorQualifications) {
		Tutor existingTutor = tutorRepository.findById(tutorId).orElseThrow();
		existingTutor.addTutorQualification(tutorQualifications);
		tutorQualificationRepository.save(tutorQualifications);
		return "Tutor Qualifications added succesfully";
	}
	
	
}
