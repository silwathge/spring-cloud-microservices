package com.kapila.demo.service;

import java.util.List;

import com.kapila.demo.vo.EnrollmentVo;

public interface EnrollmentService {

	List<EnrollmentVo> getAllEnrollmentList();

	EnrollmentVo findEnrollmentById(String id);

	String saveEnrollment(EnrollmentVo vo);

	void updateEnrollment(EnrollmentVo vo);

	void deleteEnrollment(String id);

}