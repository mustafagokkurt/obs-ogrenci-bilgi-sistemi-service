package com.mg.obs.repository;

import java.util.List;

import com.mg.obs.criteria.SearchCriteria;
import com.mg.obs.entity.Student;

public interface StudentRepositoryCustom {
	
	public List<Student> findAll(List<SearchCriteria> searchCriterias);
	
	public List<Student> findAll(String tckn, String adi, int sehir, int ilce, String telefon);
}
