package com.mg.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.obs.criteria.SearchCriteria;
import com.mg.obs.entity.Student;
import com.mg.obs.repository.IdSequenceRepository;
import com.mg.obs.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	IdSequenceRepository idSequenceRepo;
	
	public List<Student> getAll(){
		return studentRepo.findAll();
	}
	
	public List<Student> getAll(List<SearchCriteria> searchCriterias){
		return studentRepo.findAll(searchCriterias);
	}
	
	public List<Student> getAll(String tckn, String adi, int sehir, int ilce, String telefon){
		return studentRepo.findAll(tckn, adi, sehir, ilce, telefon);
	}
	
	public Student save(Student student){
		
		if(student.getId() == 0) {
			student.setId(idSequenceRepo.generateSequence(Student.SEQUENCE_NAME));
		}
		
		return studentRepo.save(student);
	}
	
	public void delete(Student student){
		studentRepo.deleteById((long) student.getId());
	}
	
}
