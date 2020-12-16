package com.kapila.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kapila.demo.client.fallback.ClassServiceClientFallback;
import com.kapila.demo.vo.ClassVo;

@FeignClient(name = "http://${client.sclass.service.app.name}", fallback = ClassServiceClientFallback.class)
@RequestMapping("/api/v1")
public interface ClassServiceClient {
	
	@GetMapping("/classes/{id}")
	public ResponseEntity<ClassVo> getClass(@PathVariable("id") String id);

}
