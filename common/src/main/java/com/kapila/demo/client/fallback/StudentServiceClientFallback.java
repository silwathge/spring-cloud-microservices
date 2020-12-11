package com.kapila.demo.client.fallback;

import org.springframework.http.ResponseEntity;

import com.kapila.demo.client.StudentServiceClient;
import com.kapila.demo.exception.ClassNotFoundException;
import com.kapila.demo.vo.StudentVo;

public class StudentServiceClientFallback implements StudentServiceClient {

	@Override
	public ResponseEntity<StudentVo> getStudent(String id) {
		//throw new ClassNotFoundException("Try again later temp msg");
		return null;
	}

}
