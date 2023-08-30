package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.StudentEducationalDetails;
@Repository
public interface StudentEduDetailsRepository extends JpaRepository<StudentEducationalDetails, Long> {
//	@Query(value = "INSERT into StudentEducationalDetails(stream,level,board,student) select "
//			+ ":details.stream,:details.level,:details.board,:student")
//	void addStudentEducationalDetails
//	(@Param("student") Long studentId, @Param("details") StudentEducationalDetails request);
}
