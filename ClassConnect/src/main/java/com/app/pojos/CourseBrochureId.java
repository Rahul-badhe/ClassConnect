package com.app.pojos;

import java.io.Serializable;

public class CourseBrochureId implements Serializable{
	private Long courseId;
	private Long tutorId;
	
	public CourseBrochureId() {
		super();
	}

	public CourseBrochureId(Long courseId, Long tutorId) {
		super();
		this.courseId = courseId;
		this.tutorId = tutorId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getTutorId() {
		return tutorId;
	}

	public void setTutorId(Long tutorId) {
		this.tutorId = tutorId;
	}

}
