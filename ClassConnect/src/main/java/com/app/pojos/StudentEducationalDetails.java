package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student_educational_details")
public class StudentEducationalDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stud_edu_details_id")
	private Long studEduDetailsId;
	@Column(length = 30, nullable = false)
	private String stream;
	@Column(length = 30, nullable = false)
	private String level;
	@Column(length = 30, nullable = false)
	private String board;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "student_id",unique = true)
	private Student student;
	
	public void addStudent(Student student) {
		this.setStudent(student);
		student.setDetails(this);
	}
	
	public StudentEducationalDetails() {
		super();
	}

	public StudentEducationalDetails(String stream, String level, String board) {
		super();
		this.stream = stream;
		this.level = level;
		this.board = board;
	}
	
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getStudEduDetailsId() {
		return studEduDetailsId;
	}

	public void setStudEduDetailsId(Long studEduDetailsId) {
		this.studEduDetailsId = studEduDetailsId;
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
	
	

	@Override
	public String toString() {
		return "StudentEducationalDetails [studEduDetailsId=" + studEduDetailsId + ", stream=" + stream + ", level="
				+ level + ", board=" + board + "]";
	}
	
}
