package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "course_enrollment")
public class CourseEnrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enrollment_id")
	private Long enrollmentId;
	@Column(name = "enrollment_date")
	@CreationTimestamp
	private LocalDate enrollmentDate;
	@Column(name = "payment_transaction_id", length = 50, nullable = false)
	private String paymentTransactionId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private CourseBrochure courseBrochure;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;
	
	public CourseEnrollment() {
		super();
	}

	public CourseEnrollment(String paymentTransactionId) {
		super();
		this.paymentTransactionId = paymentTransactionId;
	}

	public Long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getPaymentTransactionId() {
		return paymentTransactionId;
	}

	public void setPaymentTransactionId(String paymentTransactionId) {
		this.paymentTransactionId = paymentTransactionId;
	}
	
	public CourseBrochure getCourseBrochure() {
		return courseBrochure;
	}

	public void setCourseBrochure(CourseBrochure courseBrochure) {
		this.courseBrochure = courseBrochure;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "CourseEnrollment [enrollmentId=" + enrollmentId + ", enrollmentDate=" + enrollmentDate
				+ ", paymentTransactionId=" + paymentTransactionId + "]";
	}
	
}
