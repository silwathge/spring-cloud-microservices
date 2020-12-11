package com.kapila.demo.service;

import java.util.List;

import com.kapila.demo.vo.ClassVo;

public interface ClassService {

	List<ClassVo> getAllClassList();

	ClassVo findClassById(String id);

	String saveClass(ClassVo vo);

	void updateClass(ClassVo vo);

	void deleteClass(String id);

}