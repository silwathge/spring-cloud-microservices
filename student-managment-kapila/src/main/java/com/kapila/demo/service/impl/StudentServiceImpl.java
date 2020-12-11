package com.kapila.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapila.demo.entity.Student;
import com.kapila.demo.exception.StudentAlreadyExistException;
import com.kapila.demo.exception.StudentNotFoundException;
import com.kapila.demo.repository.StudentRepository;
import com.kapila.demo.service.StudentService;
import com.kapila.demo.vo.StudentVo;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository repo;
	
	@Autowired
	public void setRepo(StudentRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<StudentVo> getAllStudentList() {

		return repo.findAll().stream().map(s -> {
			return new StudentVo(s.getId(), s.getStudentName(), s.getAge());
		}).collect(Collectors.toList());
	}

	@Override
	public StudentVo findStudentById(String id) throws StudentNotFoundException {
		
		return ifStudentNotExistThrowExceptoinElseReturn(id).map(s -> {
			return new StudentVo(s.getId(), s.getStudentName(), s.getAge());
		}).orElse(null);
	}

	@Override
	public String saveStudent(StudentVo vo) {

		String id = vo.getStudentId();
		if (repo.findById(id).isPresent()) {
			throw new StudentAlreadyExistException(id + " - student already exist");
		}

		Student student = new Student(id, vo.getStudentName(), vo.getAge());
		student = repo.save(student);
		return student.getId();
	}

	@Override
	public void updateStudent(StudentVo vo) {
		
		Student student = ifStudentNotExistThrowExceptoinElseReturn(vo.getStudentId()).get();
		student.setStudentName(vo.getStudentName());
		student.setAge(vo.getAge());
		
		repo.save(student);
	}

	@Override
	public void deleteStudent(String id) {
		
		Student student = ifStudentNotExistThrowExceptoinElseReturn(id).get();		
		repo.delete(student);

	}

	private Optional<Student> ifStudentNotExistThrowExceptoinElseReturn(String studentId) {
		
		Optional<Student> student = repo.findById(studentId);
		if (!student.isPresent()) {
			throw new StudentNotFoundException(studentId + " - student not found");
		}
		return student;
	}

}
