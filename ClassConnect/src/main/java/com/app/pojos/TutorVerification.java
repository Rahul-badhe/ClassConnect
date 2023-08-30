package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tutor_verification")
public class TutorVerification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_verification_id")
	private Long tutorVerificationId;
	@CreationTimestamp
	@JoinColumn(name = "registration_date")
	private LocalDate registrationDate;
	@Column(name="verification_status", nullable = false, length=30)
	@Enumerated(EnumType.STRING)
	private VerificationStatus status;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;

	public TutorVerification() {
		super();
		this.status = VerificationStatus.PENDING;
	}

	public Long getTutorVerificationId() {
		return tutorVerificationId;
	}

	public void setTutorVerificationId(Long tutorVerificationId) {
		this.tutorVerificationId = tutorVerificationId;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public VerificationStatus getStatus() {
		return status;
	}

	public void setStatus(VerificationStatus status) {
		this.status = status;
	}
	
	public void addTutor(Tutor existingTutor) {
		this.setTutor(existingTutor);
		existingTutor.setVerification(this);
	}
}
