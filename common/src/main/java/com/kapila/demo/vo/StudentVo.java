package com.kapila.demo.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@AllArgsConstructor @NoArgsConstructor  @Getter
public class StudentVo {

	@NotBlank
	@Size(min = 5, max= 25, message = "Student Id must be at least 5 characters. max is 25.")
	private String studentId;
	
	@NotBlank
	@Size(min = 3, max= 100, message = "Student Name must be at least 3 characters. max is 100.")
	private String studentName;
	
	@NotBlank
	@Max(value = 120, message = "Age max is 120.")
	@Min(value = 1, message = "Age min is 1.")
	private String age;

	public StudentVo(@NotNull @Size(min = 12, message = "Name should have atleast 2 characters") String studentId,
			String studentName, String age) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
	}

	public StudentVo() {
		super();

	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentVo [studentId=" + studentId + ", studentName=" + studentName + ", age=" + age + "]";
	}
	
	

}
