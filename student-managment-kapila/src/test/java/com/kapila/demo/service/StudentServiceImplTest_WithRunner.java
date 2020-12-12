package com.kapila.demo.service;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.kapila.demo.entity.Student;
import com.kapila.demo.exception.StudentNotFoundException;
import com.kapila.demo.repository.StudentRepository;
import com.kapila.demo.service.impl.StudentServiceImpl;
import com.kapila.demo.vo.StudentVo;

@RunWith(EasyMockRunner.class)
public class StudentServiceImplTest_WithRunner {
	
	@TestSubject
	private StudentServiceImpl service = new StudentServiceImpl();
	@Mock
	private StudentRepository repoMock;

	@Before
	public void setUp() throws Exception {		

		expect(repoMock.findById("S0001")).andReturn(Optional.of(new Student("S0001", "", "")));
		expect(repoMock.findById("S0002")).andReturn(Optional.<Student>empty());
		List<Student> students = Arrays.asList(new Student[] { new Student(), new Student() });		
		expect(repoMock.findAll()).andReturn(students);

		replay(repoMock);

	}

	@Test
	public void testFindStudentById_NotNull() {

		StudentVo svo = service.findStudentById("S0001");
		assertNotNull(svo);
	}

	@Test
	public void testFindStudentById_ThrowsNotFoundException() {

		assertThrows(StudentNotFoundException.class, () -> service.findStudentById("S0002"));

	}

	@Test
	public void testGetAllStudentList_returnResults() {

		List<StudentVo> returnedStudentList = service.getAllStudentList();
		assertFalse(returnedStudentList.isEmpty());

	}

	@Test
	public void testGetAllStudentList_returnCorrectNoOfObject() {

		List<StudentVo> returnedStudentList = service.getAllStudentList();
		assertEquals(2, returnedStudentList.size());

	}

	@Test
	public void testGetAllStudentList_returnEmptyList() {
		reset(repoMock);
		List<Student> studentsEmpty = Arrays.asList(new Student[] {});
		expect(repoMock.findAll()).andReturn(studentsEmpty);
		replay(repoMock);
		List<StudentVo> returnedStudentList = service.getAllStudentList();
		assertEquals(0, returnedStudentList.size());		

	}

}
