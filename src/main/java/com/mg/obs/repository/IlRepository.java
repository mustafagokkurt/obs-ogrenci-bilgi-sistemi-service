package com.mg.obs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mg.obs.entity.IlBilgisi;

public interface IlRepository extends MongoRepository<IlBilgisi, Long> {

}
