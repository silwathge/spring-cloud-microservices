package com.kapila.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kapila.demo.client.fallback.StudentServiceClientFallback;
import com.kapila.demo.vo.StudentVo;

@FeignClient(name = "http://${client.student.service.app.name}",fallback = StudentServiceClientFallback.class)
@RequestMapping("/api/v1")
public interface StudentServiceClient {
	
	@GetMapping("/students/{id}")
	public ResponseEntity<StudentVo> getStudent(@PathVariable("id") String id);
	
}
