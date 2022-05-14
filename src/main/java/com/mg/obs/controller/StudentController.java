package com.mg.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
			@RequestParam(required = false) String soyadi,
			@RequestParam(required = false) String telefon, 
			@RequestParam(required = false, defaultValue = "0") int sehir,
			@RequestParam(required = false, defaultValue = "0") int ilce) {				
		
		List<Student> list = studentService.getAll(tckn, adi, soyadi, sehir, ilce, telefon);
		//Student student = new Student();

		return list;				 		    
	}
	
	@PostMapping("/save")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Student save(@RequestBody Student student) {
		Student retVal = studentService.save(student);
		return retVal;
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody Student student) {
		studentService.delete(student);
	}
	
	@GetMapping("/{id}")
	public Student getById(@PathVariable long id) {
		return this.studentService.findById(id);
	}
	
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable long id) {
//		studentService.findById(0);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
