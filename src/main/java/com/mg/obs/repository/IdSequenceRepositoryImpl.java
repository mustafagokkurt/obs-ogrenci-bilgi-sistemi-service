package com.mg.obs.repository;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mg.obs.entity.IdSequence;

public class IdSequenceRepositoryImpl implements IdSequenceRepositoryCustom  {

	MongoTemplate mongoTemplate;	
	
//	@Autowired
//	IdSequenceRepository idSequenceRepo;
	
	@Autowired
	public void setMongoTemplate(@Lazy MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public int generateSequence(String seqName) {
		Query query = new Query(Criteria.where("_id").is(seqName));
		Update update = new Update().inc("seq",1);
		
	    IdSequence counter = mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(true), IdSequence.class);
	    return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}
		
}
