package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Student;
import java.lang.String;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByEmailId(String emailid);
}
