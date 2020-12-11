package com.kapila.demo.entity;

import org.springframework.data.annotation.Id;

//@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString 
public class Class {

	@Id
	private String id;
	private String className;
	private String description;

	public Class() {
		super();

	}

	public Class(String id, String className, String description) {
		super();
		this.id = id;
		this.className = className;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", className=" + className + ", description=" + description + "]";
	}
	
	

}
