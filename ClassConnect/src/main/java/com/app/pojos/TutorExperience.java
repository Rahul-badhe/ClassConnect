package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tutor_experiences")
public class TutorExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_experience_id")
	private Long tutorExperienceId;
	@Column(name = "number_of_years",nullable = false)
	private Integer numberOfYears;
	@Column(name = "organisation_name",length = 30, nullable = false)
	private String organisationName;
	@Column(length = 30, nullable = false)
	private String field;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;
	
	public TutorExperience() {
		super();
	}

	public TutorExperience(Integer numberOfYears, String organisationName, String field) {
		super();
		this.numberOfYears = numberOfYears;
		this.organisationName = organisationName;
		this.field = field;
	}

	public Long getTutorExperienceId() {
		return tutorExperienceId;
	}

	public void setTutorExperienceId(Long tutorExperienceId) {
		this.tutorExperienceId = tutorExperienceId;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Integer getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(Integer numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
