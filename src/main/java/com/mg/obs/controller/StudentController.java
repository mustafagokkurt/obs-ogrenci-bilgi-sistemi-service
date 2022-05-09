package com.mg.obs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mg.obs.criteria.SearchCriteria;
import com.mg.obs.entity.Student;
import com.mg.obs.service.StudentService;

@RestController
@RequestMapping(path="/students", produces="application/json")
@CrossOrigin(origins="*")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
//	@GetMapping(path = "")
//	public List<Student> getAll(@RequestParam(value = "search") String search) {		
//		List<SearchCriteria> searchCriterias = new ArrayList<SearchCriteria>();
//		
//		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
//	        Matcher matcher = pattern.matcher(search + ",");
//	        while (matcher.find()) {
//	        	searchCriterias.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
//	        }
//		
//		
//		List<Student> list = studentService.getAll(searchCriterias);
//		Student student = new Student();
//
//		return list;				 		    
//	}
	
	@GetMapping(path = "")
	public List<Student> getAll(
			@RequestParam(required = false) String tckn, 
			@RequestParam(required = false) String adi, 
			@RequestParam(required = false) String telefon, 
			@RequestParam() int sehir,
			@RequestParam() int ilce) {				
		
		List<Student> list = studentService.getAll(tckn, adi, sehir, ilce, telefon);
		Student student = new Student();

		return list;				 		    
	}
	
	@PostMapping("/add")
	public Student add(@RequestBody Student student) {
		Student retVal = studentService.save(student);
		return retVal;
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody Student student) {
		studentService.delete(student);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
