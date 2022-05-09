package com.mg.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mg.obs.entity.IlBilgisi;
import com.mg.obs.entity.Student;
import com.mg.obs.service.StudentService;
import com.mg.obs.service.UtilService;

@RestController
@RequestMapping(path="/util/", produces="application/json")
@CrossOrigin(origins="*")
public class UtilController {

	@Autowired
	private UtilService utilService;
	
	@GetMapping(path = "/cities")
	public List<IlBilgisi> getAll() {		
		List<IlBilgisi> list = utilService.getAllCities();		

		return list;				 		    
	}
}
