package com.mg.obs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mg.obs.entity.IdSequence;

public interface IdSequenceRepository extends MongoRepository<IdSequence, String>, IdSequenceRepositoryCustom{

}
