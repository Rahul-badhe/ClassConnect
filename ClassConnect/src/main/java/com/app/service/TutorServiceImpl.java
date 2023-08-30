package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Tutor;
import com.app.repository.TutorRepository;

@Service
@Transactional
public class TutorServiceImpl implements TutorService {
	
	@Autowired
	private TutorRepository tutorRepository;

	@Override
	public Tutor findTutorByEmail(String email) {
		Tutor existingTutor = tutorRepository.findByEmailId(email);
		return existingTutor;
	}

}
