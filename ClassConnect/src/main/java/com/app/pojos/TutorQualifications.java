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
@Table(name = "tutor_qualifications")
public class TutorQualifications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_qualification_id")
	private Long tutorQualificationId;
	
	@Column(length = 30, nullable = false)
	private String stream;
	@Column(length = 30, nullable = false)
	private String level;
	@Column(length = 30, nullable = false)
	private String board;
	@Column(name = "passing_year",nullable = false)
	private Integer passingYear;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;
	
	public TutorQualifications() {
		super();
	}

	public TutorQualifications(String stream, String level, String board, Integer passingYear) {
		super();
		this.stream = stream;
		this.level = level;
		this.board = board;
		this.passingYear = passingYear;
	}
	
	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Long getTutorQualificationId() {
		return tutorQualificationId;
	}

	public void setTutorQualificationId(Long tutorQualificationId) {
		this.tutorQualificationId = tutorQualificationId;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public Integer getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(Integer passingYear) {
		this.passingYear = passingYear;
	}

}