package com.mg.obs.repository;

import java.util.List;

import com.mg.obs.criteria.SearchCriteria;
import com.mg.obs.entity.Student;

public interface IdSequenceRepositoryCustom {
	
	public int generateSequence(String seqName);
}
