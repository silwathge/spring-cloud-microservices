package com.kapila.demo.service;

import java.util.List;

import com.kapila.demo.vo.StudentVo;

public interface StudentService {

	List<StudentVo> getAllStudentList();

	StudentVo findStudentById(String id);

	String saveStudent(StudentVo vo);

	void updateStudent(StudentVo vo);

	void deleteStudent(String id);

}