package com.kapila.demo.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

//@AllArgsConstructor @NoArgsConstructor  @Getter
public class ClassVo {

	
	@NotBlank
	@Size(min = 5, max= 25, message = "Class Id must be at least 5 characters. max is 25.")
	private String classId;
	
	@NotBlank
	@Size(min = 3, max= 100, message = "Class Name must be at least 3 characters. max is 100.")
	private String className;
	
	@Size(min = 1, max= 250, message = "Class Description must be at least 1 characters. max is 250.")
	@NotBlank	
	private String description;

	public ClassVo(@NotNull @Size(min = 12, message = "Name should have atleast 2 characters") String classId,
			String className, String age) {
		super();
		this.classId = classId;
		this.className = className;
		this.description = age;
	}

	public ClassVo() {
		super();

	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String age) {
		this.description = age;
	}

	@Override
	public String toString() {
		return "ClassVo [classId=" + classId + ", className=" + className + ", description=" + description + "]";
	}
	
	

}
