package com.kapila.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kapila.demo.service.EnrollmentService;
import com.kapila.demo.vo.EnrollmentVo;

@RestController
@RequestMapping("/api/v1")
public class EnrollmentRestController {
	
	private static Logger log = LoggerFactory.getLogger(EnrollmentRestController.class);
	
	@Autowired
	private EnrollmentService service;

	@GetMapping("/enrollments/{id}")
	public EnrollmentVo getEnrollment(@PathVariable String id) {
		
		return service.findEnrollmentById(id);
		
	}

	@GetMapping("/enrollments")
	public List<EnrollmentVo> getEnrollmentsList() {

		return service.getAllEnrollmentList();

	}

	@PostMapping("/enrollments")
	public ResponseEntity<Object> saveEnrollment(@Valid @RequestBody EnrollmentVo enrollmentVo) {
		log.info("request {}",enrollmentVo);
		String id = service.saveEnrollment(enrollmentVo);
		log.info("response enrollment id {}",id);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/enrollments")
	public ResponseEntity<Object> updateEnrollment(@Valid @RequestBody EnrollmentVo enrollmentVo) {

		service.updateEnrollment(enrollmentVo);

		return new ResponseEntity<>("Enrollment successfully updated", HttpStatus.OK);

	}

	@DeleteMapping("/enrollments/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		service.deleteEnrollment(id);
		return new ResponseEntity<>("Enrollment successfully deleted", HttpStatus.OK);
	}

}
