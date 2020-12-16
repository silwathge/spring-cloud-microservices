package com.kapila.demo.async;

import java.util.concurrent.Callable;

import org.springframework.http.ResponseEntity;

import com.kapila.demo.client.ClassServiceClient;
import com.kapila.demo.vo.ClassVo;


public class ClassServiceCallable implements Callable<ResponseEntity<ClassVo>> {
	
	
	private ClassServiceClient classServiceClient;
	
	private String id;
	
	@Override
	public ResponseEntity<ClassVo> call() throws Exception {
		
		return classServiceClient.getClass(id);
	}

	public ClassServiceCallable(ClassServiceClient classServiceClient, String id) {
		super();
		this.classServiceClient = classServiceClient;
		this.id = id;
	}

	
}
