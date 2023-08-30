package com.app.dto;

import java.time.LocalDate;
import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class StudentDto {
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String emailId;
	private String password;
	private String gender;
	private byte[] profilePhoto;
	private byte[] idProof;
	private LocalDate dob;
	
	public StudentDto() {
		super();
	}

	public StudentDto(String firstName, String lastName, String mobileNo, String emailId, String password,
			String gender, byte[] profilePhoto, byte[] idProof, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
		this.gender = gender;
		this.profilePhoto = profilePhoto;
		this.idProof = idProof;
		this.dob = dob;
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

	public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public byte[] getIdProof() {
		return idProof;
	}

	public void setIdProof(byte[] idProof) {
		this.idProof = idProof;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "StudentDto [firstName=" + firstName + ", lastName=" + lastName + ", mobileNo=" + mobileNo + ", emailId="
				+ emailId + ", password=" + password + ", gender=" + gender + ", profilePhoto="
				+ Arrays.toString(profilePhoto) + ", idProof=" + Arrays.toString(idProof) + ", dob=" + dob + "]";
	}
	
	
}
