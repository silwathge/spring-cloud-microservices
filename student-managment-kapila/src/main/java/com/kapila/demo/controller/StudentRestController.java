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

import com.kapila.demo.service.StudentService;
import com.kapila.demo.vo.StudentVo;

@RestController
@RequestMapping("/api/v1")
public class StudentRestController {
	
	private static Logger log = LoggerFactory.getLogger(StudentRestController.class);
	
	@Autowired
	private StudentService service;

	@GetMapping("/students/{id}")
	public ResponseEntity<StudentVo> getStudent(@PathVariable String id) {
		
		log.info("request {}",id);
		ResponseEntity<StudentVo> response = null;
		StudentVo vo = null;
		try {
			vo = service.findStudentById(id);
			response =new  ResponseEntity<StudentVo>(vo,HttpStatus.OK);
		} catch (com.kapila.demo.exception.StudentNotFoundException e) {
			response =new  ResponseEntity<StudentVo>(vo,HttpStatus.NOT_FOUND);
		}
		log.info("response {}",response);
		return response;
		
	}

	@GetMapping("/students")
	public List<StudentVo> getStudentsList() {

		return service.getAllStudentList();

	}

	@PostMapping("/students")
	public ResponseEntity<Object> saveStudent(@Valid @RequestBody StudentVo studentVo) {

		String id = service.saveStudent(studentVo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/students")
	public ResponseEntity<Object> updateStudent(@Valid @RequestBody StudentVo studentVo) {

		service.updateStudent(studentVo);

		return new ResponseEntity<>("Student successfully updated", HttpStatus.OK);

	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		service.deleteStudent(id);
		return new ResponseEntity<>("Student successfully deleted", HttpStatus.OK);
	}

}
