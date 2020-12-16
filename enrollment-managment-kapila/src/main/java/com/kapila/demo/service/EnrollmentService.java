package com.kapila.demo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

import com.kapila.demo.vo.ClassVo;
import com.kapila.demo.vo.EnrollmentVo;
import com.kapila.demo.vo.StudentVo;

public interface EnrollmentService {

	List<EnrollmentVo> getAllEnrollmentList();

	EnrollmentVo findEnrollmentById(String id);

	String saveEnrollment(EnrollmentVo vo);

	void updateEnrollment(EnrollmentVo vo);

	void deleteEnrollment(String id);
	
	public CompletableFuture<ResponseEntity<ClassVo>> getClassAsync(String id);
	
	public CompletableFuture<ResponseEntity<StudentVo>> getStudentAsync(String id);

}