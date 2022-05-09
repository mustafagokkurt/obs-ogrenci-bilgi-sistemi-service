package com.mg.obs.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mg.obs.criteria.SearchCriteria;
import com.mg.obs.entity.Student;

public class StudentRepositoryImpl implements StudentRepositoryCustom {

	MongoTemplate mongoTemplate;
	
	
	@Autowired
	public void setMongoTemplate(@Lazy MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<Student> findAll(List<SearchCriteria> searchCriterias) {
		
		Query query = new Query();
		searchCriterias.forEach(criteria ->{
			query.addCriteria(Criteria.where(criteria.getKey()).regex((String) criteria.getValue()));
		});
		//query.fields().include("MusteriNo").include("BirimRowId");

		//LOGGER.info("query - " + query.toString());	
		List<Student> result = mongoTemplate
				.find(query, Student.class)
				.stream()
				.collect(Collectors.toList());
		
		return result;
		
	}

	@Override
	public List<Student> findAll(String tckn, String adi, int sehir, int ilce, String telefon) {
		Query query = new Query();
		
		if(tckn != null && !tckn.isEmpty()) query.addCriteria(Criteria.where("Tckn").regex(tckn.toString()));
		if(adi != null && !adi.isEmpty()) query.addCriteria(Criteria.where("Adi").regex(adi));
		if(sehir > 0) query.addCriteria(Criteria.where("Sehir").is(sehir));
		if(ilce > 0) query.addCriteria(Criteria.where("Ilce").is(ilce));
		if(telefon!=null && !telefon.isEmpty()) query.addCriteria(Criteria.where("Telefon").regex(telefon));
			
		//query.fields().include("MusteriNo").include("BirimRowId");

		//LOGGER.info("query - " + query.toString());	
		List<Student> result = mongoTemplate
				.find(query, Student.class)
				.stream()
				.collect(Collectors.toList());
		
		return result;

	}

}
