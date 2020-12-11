package com.kapila.demo.async;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.kapila.demo.client.ClassServiceClient;
import com.kapila.demo.client.StudentServiceClient;
import com.kapila.demo.vo.ClassVo;
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
