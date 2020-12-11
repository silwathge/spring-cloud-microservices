package com.kapila.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kapila.demo.entity.Class;

@Repository
public interface ClassRepository extends MongoRepository<Class, String> {	

}
