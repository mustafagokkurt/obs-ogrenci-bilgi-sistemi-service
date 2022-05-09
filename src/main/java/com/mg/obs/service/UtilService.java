package com.mg.obs.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mg.obs.entity.IdSequence;
import com.mg.obs.entity.IlBilgisi;
import com.mg.obs.repository.IdSequenceRepository;
import com.mg.obs.repository.IlRepository;

@Service
public class UtilService {

	@Autowired
	IlRepository ilRepo;

	@Autowired
	IdSequenceRepository idSequenceRepo;

	public List<IlBilgisi> getAllCities() {
		return ilRepo.findAll();
	}

	public long generateSequence(String seqName) {
		return idSequenceRepo.generateSequence(seqName);
	}
}
