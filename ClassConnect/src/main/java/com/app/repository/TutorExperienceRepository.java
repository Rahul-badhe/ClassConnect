package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.TutorExperience;

@Repository
public interface TutorExperienceRepository extends JpaRepository<TutorExperience, Long> {

}
