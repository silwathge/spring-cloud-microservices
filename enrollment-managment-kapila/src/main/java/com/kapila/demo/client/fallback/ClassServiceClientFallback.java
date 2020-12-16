package com.kapila.demo.client.fallback;

import org.springframework.http.ResponseEntity;

import com.kapila.demo.client.ClassServiceClient;
import com.kapila.demo.vo.ClassVo;

public class ClassServiceClientFallback implements ClassServiceClient {

	@Override
	public ResponseEntity<ClassVo> getClass(String id) {
		//throw new ClassNotFoundException("Try again later temp msg ClassServiceClientFallback");
		return null;
	}

}
