package com.kapila.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Enrollment {

	@Id
	private String id;
	private String classId;
	private String studentId;
	private LocalDateTime updated;

	public Enrollment() {
		super();

	}

	public Enrollment(String id, String classId, String studentId, LocalDateTime updated) {
		super();
		this.classId = classId;
		this.studentId = studentId;
		this.updated = updated;
		this.id = id;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", classId=" + classId + ", studentId=" + studentId + ", updated=" + updated
				+ "]";
	}   
	
	
	
}
