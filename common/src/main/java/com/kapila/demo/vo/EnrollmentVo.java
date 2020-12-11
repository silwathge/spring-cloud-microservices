package com.kapila.demo.vo;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EnrollmentVo {

	private String id;

	@NotBlank
	@Size(min = 3, max = 100, message = "Class Id must be at least 5 characters. max is 25.")
	private String classId;

	@NotBlank
	@Size(min = 5, max = 25, message = "Student Id must be at least 5 characters. max is 25.")
	private String studentId;

	private LocalDateTime updated;

	public EnrollmentVo(String id, String classId, String studentId, LocalDateTime updated) {
		super();
		this.id = id;		
		this.classId = classId;
		this.studentId = studentId;
		this.updated = updated;
	}

	public EnrollmentVo() {
		super();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@Override
	public String toString() {
		return "EnrollmentVo [id=" + id + ", classId=" + classId + ", studentId=" + studentId + ", updated=" + updated
				+ "]";
	}
	
	

}
