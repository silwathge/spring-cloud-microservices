package com.kapila.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.kapila.demo.client.ClassServiceClient;
import com.kapila.demo.client.StudentServiceClient;
import com.kapila.demo.entity.Enrollment;
import com.kapila.demo.exception.ClassNotFoundException;
import com.kapila.demo.exception.EnrollmentAlreadyExistException;
import com.kapila.demo.exception.EnrollmentNotFoundException;
import com.kapila.demo.exception.ServiceNotAvaiableException;
import com.kapila.demo.exception.StudentNotFoundException;
import com.kapila.demo.repository.EnrollmentRepository;
import com.kapila.demo.service.EnrollmentService;
import com.kapila.demo.vo.ClassVo;
import com.kapila.demo.vo.EnrollmentVo;
import com.kapila.demo.vo.StudentVo;

import feign.FeignException.NotFound;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	private static Logger log = LoggerFactory.getLogger(EnrollmentServiceImpl.class);

	@Autowired
	private EnrollmentRepository repo;

	@Autowired
	private StudentServiceClient studentServiceClient;

	@Autowired
	private ClassServiceClient classServiceClient;
	
	@Override
	public List<EnrollmentVo> getAllEnrollmentList() {

		return repo.findAll().stream().map(e -> {
			return new EnrollmentVo(e.getId(), e.getClassId(), e.getStudentId(), e.getUpdated());
		}).collect(Collectors.toList());
	}

	@Override
	public EnrollmentVo findEnrollmentById(String id) {

		return ifEnrollmentNotExistThrowExceptoinElseReturn(id).map(e -> {
			return new EnrollmentVo(e.getId(), e.getClassId(), e.getStudentId(), e.getUpdated());
		}).orElse(null);
	}

	@Override
	public String saveEnrollment(EnrollmentVo vo) {

		log.info("request:" + vo);
		String id = vo.getClassId() + "-" + vo.getStudentId();

		if (repo.findById(id).isPresent()) {
			log.info(id + " - enrollment already exist");
			throw new EnrollmentAlreadyExistException(id + " - enrollment already exist");
		}		
		this.getStudent(vo.getStudentId());
		this.getClass(vo.getClassId());
		
// 		CompletableFuture<ResponseEntity<StudentVo>> studentAsync = getStudentAsync(vo.getStudentId());
// 		CompletableFuture<ResponseEntity<ClassVo>> classAsync = getClassAsync(vo.getClassId());
// 		CompletableFuture.allOf(classAsync, studentAsync).join();
//		 try {
//			classAsync.get();
//			studentAsync.get();
//		 } catch (InterruptedException | ExecutionException e) {			
//			 log.error("error in calling calss service and/or student service",e);
//			 throw new ServiceNotAvaiableException("error in calling student and/or class service , try again later");
//		}
		
		Enrollment enrollment = new Enrollment(id, vo.getClassId(), vo.getStudentId(), LocalDateTime.now());
		enrollment = repo.save(enrollment);
		log.info("reponse entity:" + vo);
		return enrollment.getId();
	}

	@Override
	public void updateEnrollment(EnrollmentVo vo) {
		String id = vo.getClassId() + "-" + vo.getStudentId();

		Enrollment enroll = ifEnrollmentNotExistThrowExceptoinElseReturn(id).get();
		enroll.setClassId(vo.getClassId());
		enroll.setStudentId(vo.getStudentId());
		enroll.setUpdated(LocalDateTime.now());

		repo.save(enroll);
	}

	@Override
	public void deleteEnrollment(String id) {
		Enrollment enrollment = ifEnrollmentNotExistThrowExceptoinElseReturn(id).get();
		repo.delete(enrollment);

	}

	private Optional<Enrollment> ifEnrollmentNotExistThrowExceptoinElseReturn(String enrollmentId) {

		Optional<Enrollment> enrollment = repo.findById(enrollmentId);
		if (!enrollment.isPresent()) {
			throw new EnrollmentNotFoundException(enrollmentId + " - enrollment not found");
		}
		return enrollment;
	}

	private ResponseEntity<StudentVo> getStudent(String id) {
		try {
			log.info("calling student service");
			return studentServiceClient.getStudent(id);

		} catch (NotFound e) {
			throw new StudentNotFoundException(id + " - student not found");
		} catch (Exception ee) {
			throw new ServiceNotAvaiableException("student service not available, try again later");
		}
	}

	private ResponseEntity<ClassVo> getClass(String id) {
		try {
			log.info("calling class service");
			return classServiceClient.getClass(id);

		} catch (NotFound e) {
			throw new ClassNotFoundException(id + " - class not found");
		} catch (Exception ee) {
			throw new ServiceNotAvaiableException("class service not available, try again later ");
		}
	}

	@Async("classServiceExecutor")
	public CompletableFuture<ResponseEntity<ClassVo>> getClassAsync(String id) {
		try {
			ResponseEntity<ClassVo> clas = classServiceClient.getClass(id);

			return CompletableFuture.completedFuture(clas);
		} catch (NotFound e) {
			log.error(e.getMessage(),e);
			throw new ClassNotFoundException(id + " - class not found");
		} catch (Exception ee) {
			log.error(ee.getMessage(),ee);
			throw new ServiceNotAvaiableException("class service not available, try again later ");
		}
	}

	@Async("classServiceExecutor")
	public CompletableFuture<ResponseEntity<StudentVo>> getStudentAsync(String id) {
		try {
			ResponseEntity<StudentVo> student = studentServiceClient.getStudent(id);

			return CompletableFuture.completedFuture(student);
		} catch (NotFound e) {
			log.error(e.getMessage(),e);
			throw new StudentNotFoundException(id + " - student not found");
		} catch (Exception ee) {
			log.error(ee.getMessage(),ee);
			throw new ServiceNotAvaiableException("student service not available, try again later ");
		}
	}
	
	/*
	 * private ResponseEntity<StudentVo> getStudentResttemplate(String id) { try {
	 * log.info("calling student service");
	 * restTemplate.getForObject("http://SCHOOL-STUDENT-SERVICE/api/v1/students/"+
	 * id, String.class); return studentServiceClient.getStudent(id);
	 * 
	 * } catch (NotFound e) { throw new StudentNotFoundException(id +
	 * " - student not found"); } catch (Exception ee) { throw new
	 * ServiceNotAvaiableException("student service not available, try again later"
	 * ); } }
	 */

	

}
