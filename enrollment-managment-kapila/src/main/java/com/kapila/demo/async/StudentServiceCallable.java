package com.kapila.demo.async;

import java.util.concurrent.Callable;

import org.springframework.http.ResponseEntity;

import com.kapila.demo.client.StudentServiceClient;
import com.kapila.demo.vo.StudentVo;


public class StudentServiceCallable implements Callable<ResponseEntity<StudentVo>> {
	
	
	private StudentServiceClient studentServiceClient;
	
	private String id;
	
	@Override
	public ResponseEntity<StudentVo> call() throws Exception {
		
		return studentServiceClient.getStudent(id);
	}

	public StudentServiceCallable(StudentServiceClient studentServiceClient, String id) {
		super();
		this.studentServiceClient = studentServiceClient;
		this.id = id;
	}

	
}
