package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course_brochures")
public class CourseBrochure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Long courseId;
	@Column(name = "course_name", length = 30, nullable = false)
	private String courseName;
	@Column(length = 30, nullable = false)
	private String stream;
	@Column(length = 30, nullable = false)
	private String level;
	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;
	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;
	@Column(nullable = false)
	private Integer duration;
	@Column(nullable = false)
	private Double fees;
	@Column(length = 10, nullable = false)
	private String mode;
	@Column(length = 20, nullable = false)
	private String time;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;
	
	@OneToMany(mappedBy = "courseBrochure", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<CourseEnrollment> courseEnrollment=new ArrayList<CourseEnrollment>();
	
	public CourseBrochure() {
		super();
	}

	public CourseBrochure(String courseName, String stream, String level, LocalDate startDate, LocalDate endDate,
			Integer duration, Double fees, String mode, String time) {
		super();
		this.courseName = courseName;
		this.stream = stream;
		this.level = level;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.fees = fees;
		this.mode = mode;
		this.time = time;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
	public void addCourseEnrollment(CourseEnrollment newEnrollment) {
		courseEnrollment.add(newEnrollment);
		newEnrollment.setCourseBrochure(this);
	}
}
