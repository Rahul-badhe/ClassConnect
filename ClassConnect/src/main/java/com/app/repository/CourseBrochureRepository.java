package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.CourseBrochure;

@Repository
public interface CourseBrochureRepository extends JpaRepository<CourseBrochure, Long> {

	List<CourseBrochure> findByStreamAndCourseNameAndLevel(String stream, String courseName, String level);
	
	List<CourseBrochure> findByStream(String keyword);
	List<CourseBrochure> findByCourseName(String keyword);
	List<CourseBrochure> findByLevel(String keyword);

}
