package com.kapila.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapila.demo.entity.Class;
import com.kapila.demo.exception.ClassAlreadyExistException;
import com.kapila.demo.exception.ClassNotFoundException;
import com.kapila.demo.repository.ClassRepository;
import com.kapila.demo.service.ClassService;
import com.kapila.demo.vo.ClassVo;

@Service

public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassRepository repo;

	@Override
	public List<ClassVo> getAllClassList() {

		return repo.findAll().stream().map(s -> {
			return new ClassVo(s.getId(), s.getClassName(), s.getDescription());
		}).collect(Collectors.toList());
	}

	@Override
	public ClassVo findClassById(String id) {
		
		return ifClassNotExistThrowExceptoinElseReturn(id).map(s -> {
			return new ClassVo(s.getId(), s.getClassName(), s.getDescription());
		}).orElse(null);
	}

	@Override
	public String saveClass(ClassVo vo) {

		String id = vo.getClassId();
		if (repo.findById(id).isPresent()) {
			throw new ClassAlreadyExistException(id + " - class already exist");
		}

		Class clas = new Class(id, vo.getClassName(), vo.getDescription());
		clas = repo.save(clas);
		return clas.getId();
	}

	@Override
	public void updateClass(ClassVo vo) {
		
		Class clas = ifClassNotExistThrowExceptoinElseReturn(vo.getClassId()).get();
		clas.setClassName(vo.getClassName());
		clas.setDescription(vo.getDescription());
		
		repo.save(clas);
	}

	@Override
	public void deleteClass(String id) {
		
		Class clas = ifClassNotExistThrowExceptoinElseReturn(id).get();		
		repo.delete(clas);

	}

	private Optional<Class> ifClassNotExistThrowExceptoinElseReturn(String classId) {
		
		Optional<Class> clas = repo.findById(classId);
		if (!clas.isPresent()) {
			throw new ClassNotFoundException(classId + " - class not found");
		}
		return clas;
	}

}
