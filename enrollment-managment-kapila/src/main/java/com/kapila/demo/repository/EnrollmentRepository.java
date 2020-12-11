package com.kapila.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kapila.demo.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {	

}
