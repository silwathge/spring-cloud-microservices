package com.kapila.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.kapila.demo.entity.Student;
import com.kapila.demo.exception.StudentNotFoundException;
import com.kapila.demo.repository.StudentRepository;
import com.kapila.demo.service.impl.StudentServiceImpl;
import com.kapila.demo.vo.StudentVo;

//@RunWith(EasyMockRunner.class)
public class StudentServiceImplTest {

	private StudentServiceImpl service;
	private StudentRepository repoMock;

	@Before
	public void setUp() throws Exception {
		
		repoMock = EasyMock.createMock(StudentRepository.class);

		EasyMock.expect(repoMock.findById("S0001")).andReturn(Optional.of(new Student("S0001", "", "")));
		EasyMock.expect(repoMock.findById("S0002")).andReturn(Optional.<Student>empty());
		List<Student> students = Arrays.asList(new Student[] { new Student(), new Student() });
		EasyMock.expect(repoMock.findAll()).andReturn(students);

		EasyMock.replay(repoMock);

		service = new StudentServiceImpl();
		service.setRepo(repoMock);
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

		StudentRepository repoMock = EasyMock.createMock(StudentRepository.class);
		List students = Arrays.asList(new Student[] {});
		EasyMock.expect(repoMock.findAll()).andReturn(students);
		EasyMock.replay(repoMock);
		StudentServiceImpl service = new StudentServiceImpl();
		service.setRepo(repoMock);
		List<StudentVo> returnedStudentList = service.getAllStudentList();
		assertTrue(returnedStudentList.isEmpty());

	}

}
