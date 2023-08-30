package com.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Student;
import java.lang.String;
import java.util.List;

@Repository
//@Autowired
public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByEmailId(String emailid);
}