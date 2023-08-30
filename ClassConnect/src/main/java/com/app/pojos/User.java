package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
@Table(name = "users")
public class User{
	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 30, nullable = false)
	private String lastName;
	@Column(name = "mobile_no", length = 12, nullable = false)
	private String mobileNo;
	@Column(name = "email_id", length = 50, nullable = false, unique = true)
	private String emailId;
	@Column(length = 500, nullable = false)
	private String password;
	@Column(length = 10, nullable = false)
	private String gender;
	@Column(nullable = false)
	private LocalDate dob;
	@Column(name="isActive",nullable = false)
	private boolean isActive;
	public User() {
		super();
	}

	public User(String firstName, String lastName, String mobileNo, String emailId, String password, String gender,
			 LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.isActive = true;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", mobileNo=" + mobileNo + ", emailId="
				+ emailId + ", password=" + password + ", gender=" + gender + ", dob=" + dob + ", isActive=" + isActive
				+ "]";
	}
	
}
