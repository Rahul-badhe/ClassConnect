package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "students")
public class Student extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long studentId;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@JsonIgnore
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private StudentEducationalDetails details;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CourseEnrollment> courseEnrollment=new ArrayList<CourseEnrollment>();
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "login_id")
	private Login login;
	
	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String mobileNo, String emailId, String password, String gender,
			 LocalDate dob) {
		super(firstName, lastName, mobileNo, emailId, password, gender, dob);
	}
	
	
	public void addLogin(Login newlogin) {
		this.setLogin(newlogin);
		newlogin.setStudent(this);
	}
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	public StudentEducationalDetails getDetails() {
		return details;
	}

	public void setDetails(StudentEducationalDetails details) {
		this.details = details;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return super.toString()+" Student [studentId=" + studentId + "]";
	}

	public void addAddress(Address address) {
		this.setAddress(address);
		address.setStudent(this);
	}
	
	public void addStudentEnrollment(CourseEnrollment newEnrollment) {
		courseEnrollment.add(newEnrollment);
		newEnrollment.setStudent(this);
	}
}