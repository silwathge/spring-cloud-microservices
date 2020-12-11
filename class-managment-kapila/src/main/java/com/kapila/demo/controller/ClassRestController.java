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

import com.kapila.demo.service.ClassService;
import com.kapila.demo.vo.ClassVo;


@RestController
@RequestMapping("/api/v1")
public class ClassRestController {
	
	private static final Logger log = LoggerFactory.getLogger(ClassRestController.class);
	
	@Autowired
	private ClassService service;

	@GetMapping("/classes/{id}")
	public ResponseEntity<ClassVo> getClass(@PathVariable String id) {
		log.info("request {}",id);
		ResponseEntity<ClassVo> response = null;
		ClassVo vo = null;
		try {
			vo = service.findClassById(id);
			response =new  ResponseEntity<ClassVo>(vo,HttpStatus.OK);
		} catch (com.kapila.demo.exception.ClassNotFoundException e) {
			response =new  ResponseEntity<ClassVo>(vo,HttpStatus.NOT_FOUND);
		}
		log.info("response {}",response);
		return response;
		
	}

	@GetMapping("/classes")
	public List<ClassVo> getClassesList() {

		return service.getAllClassList();

	}

	@PostMapping("/classes")
	public ResponseEntity<Object> saveClass(@Valid @RequestBody ClassVo classVo) {

		String id = service.saveClass(classVo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/classes")
	public ResponseEntity<Object> updateClasst(@Valid @RequestBody ClassVo classVo) {

		service.updateClass(classVo);

		return new ResponseEntity<>("Class successfully updated", HttpStatus.OK);

	}

	@DeleteMapping("/classes/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		service.deleteClass(id);
		return new ResponseEntity<>("Class successfully deleted", HttpStatus.OK);
	}

}
