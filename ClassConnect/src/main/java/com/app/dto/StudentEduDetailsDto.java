package com.app.dto;


public class StudentEduDetailsDto {
	
	private String stream;
	private String level;
	private String board;
	private Long studentId;
	
	public StudentEduDetailsDto() {
		super();
	}

	public StudentEduDetailsDto(String stream, String level, String board, Long studentId) {
		super();
		this.stream = stream;
		this.level = level;
		this.board = board;
		this.studentId = studentId;
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

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
}
