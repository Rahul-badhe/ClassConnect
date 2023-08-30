package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Tutor;
import com.app.pojos.TutorExperience;
import com.app.pojos.TutorVerification;
import com.app.repository.TutorExperienceRepository;
import com.app.repository.TutorRepository;

@Service
@Transactional
public class TutorExperienceServiceImpl implements TutorExperienceService {

	@Autowired
	private TutorRepository tutorRepository;
	
	@Autowired
	private TutorExperienceRepository tutorExperienceRepository;
	
	@Override
	public String addTutorExperience(Long tutorId, TutorExperience tutorExperience) {
		Tutor existingTutor=tutorRepository.findById(tutorId).orElseThrow();
		existingTutor.addExperience(tutorExperience);
		TutorVerification tutorVerification=new TutorVerification();
		tutorVerification.addTutor(existingTutor);
		return "Tutor Experience added successfully...";
	}

}
