package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Tutor;
import java.lang.String;
import java.util.List;
@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
	Tutor findByEmailId(String emailid);
}
