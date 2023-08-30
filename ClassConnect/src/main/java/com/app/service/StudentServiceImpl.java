 package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.app.dto.StudentEduDetailsDto;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.CourseBrochure;
import com.app.pojos.CourseEnrollment;
import com.app.pojos.Student;
import com.app.pojos.StudentEducationalDetails;
import com.app.repository.CourseBrochureRepository;
import com.app.repository.CourseEnrollmentRepository;
import com.app.repository.StudentRepository;

@Transactional
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseEnrollmentRepository courseEnrollmentRepository;
	@Autowired
	private CourseBrochureRepository courseBrochureRepository;

	@Override
	public String addEnrollment(Long studentId, Long courseId, CourseEnrollment newCourseEnrollment) {
		Student existingStudent =  studentRepository.findById(studentId).orElseThrow();
		existingStudent.addStudentEnrollment(newCourseEnrollment);
		CourseBrochure existingCourseBrochure = courseBrochureRepository.findById(courseId)
				.orElseThrow();
		existingCourseBrochure.addCourseEnrollment(newCourseEnrollment);
		return "Enrollment done succesfully";
	}

	@Override
	public Student getStudentDetails(Long studentId) {
		return studentRepository.findById(studentId).orElseThrow();
	}

	@Override
	public Student updateStudentDetails(Student detachedStudent) throws ResourceNotFoundException {
		if(studentRepository.existsById(detachedStudent.getStudentId())) {
			return studentRepository.save(detachedStudent);
		}
		throw new ResourceNotFoundException("Student not found!!!");
	}

	@Override
	public Student getStudentDetails(String emailId) {
		return studentRepository.findByEmailId(emailId);
	}

	
}
