package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tutors")
public class Tutor extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_id")
	private Long tutorId;
	private String tagline;
	@Column(nullable = false)
	private String summary;
	@Column(name = "total_experience", nullable = false)
	private Integer totalExperience;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TutorQualifications> qualifications=new ArrayList<TutorQualifications>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TutorExperience> experiences=new ArrayList<TutorExperience>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CourseBrochure> courseBrochures =new ArrayList<CourseBrochure>();
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	private Login login;
	
	@JsonIgnore
	@OneToOne(mappedBy = "tutor",cascade = CascadeType.ALL,orphanRemoval = true)
	private TutorVerification verification;
	
	public Tutor() {
		super();
	}

	public Tutor(String firstName, String lastName, String mobileNo, String emailId, String password, String gender,
			LocalDate dob, String tagline, String summary, Integer totalExperience) {
		super(firstName, lastName, mobileNo, emailId, password, gender, dob);
		this.tagline = tagline;
		this.summary = summary;
		this.totalExperience = totalExperience;
	}
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Long getTutorId() {
		return tutorId;
	}

	public void setTutorId(Long tutorId) {
		this.tutorId = tutorId;
	}

	public String getTagline() {
		return tagline;
	}

	
	public TutorVerification getVerification() {
		return verification;
	}

	public void setVerification(TutorVerification verification) {
		this.verification = verification;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(Integer totalExperience) {
		this.totalExperience = totalExperience;
	}

	@Override
	public String toString() {
		return super.toString()+ " Tutor [tagline=" + tagline + ", summary=" + summary + ", totalExperience=" + totalExperience
				+ "]";
	}
	
	public void addLogin(Login newLogin) {
		this.setLogin(newLogin);
		newLogin.setTutor(this);
	}
	
	public void addAddress(Address address) {
		this.setAddress(address);
		address.setTutor(this);
	}
	
	public void addTutorQualification(TutorQualifications newtutorQualification) {
		qualifications.add(newtutorQualification);
		newtutorQualification.setTutor(this);
	}
	
	public void addExperience(TutorExperience newTutorExperience) {
		experiences.add(newTutorExperience);
		newTutorExperience.setTutor(this);
	}
	
	public void addCourseBrochure(CourseBrochure newCourseBrochure) {
		courseBrochures.add(newCourseBrochure);
		newCourseBrochure.setTutor(this);
	}
}
