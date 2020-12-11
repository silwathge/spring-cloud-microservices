package com.kapila.demo.entity;

import org.springframework.data.annotation.Id;

//@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString 
public class Student {

	@Id
	private String id;
	private String studentName;
	private String age;

	public Student() {
		super();

	}

	public Student(String id, String studentName, String age) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "Student [id=" + id + ", studentName=" + studentName + ", age=" + age + "]";
	}
	
	

}
