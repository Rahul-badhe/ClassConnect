package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "admin")
public class Admin extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long adminId;
	@Column(name = "email_id", length = 50, nullable = false, unique = true)
	private String emailId;
	@Column(length = 20, nullable = false)
	private String password;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "login_id")
	private Login login;
	
//	@JsonIgnore
//	@OneToOne
//	@JoinColumn(name = "login_id")
//	private Login login;
//	
	
	public Admin(String firstName, String lastName, String mobileNo, String emailId, String password, String gender,
			 LocalDate dob) {
		super(firstName, lastName, mobileNo, emailId, password, gender, dob);
	}
	
	public Admin() {
		super();
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Admin(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public Long getAdminId() {
		return adminId;
	}
	
	public void addLogin(Login newlogin) {
		this.setLogin(newlogin);
		newlogin.setAdmin(this);
	}
	
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
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

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", emailId=" + emailId + ", password=" + password + "]";
	}
	
	
}
