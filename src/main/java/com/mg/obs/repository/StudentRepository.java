package com.mg.obs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mg.obs.entity.Student;

public interface StudentRepository extends MongoRepository<Student, Long>, StudentRepositoryCustom  {
	

}
