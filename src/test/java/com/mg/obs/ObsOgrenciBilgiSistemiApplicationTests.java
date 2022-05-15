package com.mg.obs;

import com.mg.obs.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ObsOgrenciBilgiSistemiApplicationTests {

	String BASE_URL = "http://localhost:" + 8080 + "/students";
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Test
	void testGetAll() throws MalformedURLException {

		ResponseEntity<Student[]> response = restTemplate().getForEntity(
				new URL(BASE_URL + "?sehir=0&ilce=0&").toString(),
				Student[].class);
		
		Student[] list = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(true, list.length > 0);
	}

	@Test
	void testSave() throws MalformedURLException {

		Student student = new Student(1, "12591462426", "Mustafa", "Gökkurt", 1, 1, "5052510615");

		ResponseEntity<Student> response = restTemplate().postForEntity(
				new URL(BASE_URL + "/save").toString(), student, Student.class);
		Student responseBody = response.getBody();

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(true, responseBody.getId() > 0);
	}

	@Test
	void testDelete() throws MalformedURLException {
	
		// Arrange
		Student student = new Student(1, "", "", "", 1, 1, "");

		// Act		
		// new student insert
		ResponseEntity<Student> response = restTemplate().postForEntity(new URL(BASE_URL + "/save").toString(), student, Student.class);		

		// select student
		ResponseEntity<Student> response2 = restTemplate().getForEntity(new URL(BASE_URL + "/" + response.getBody().getId()).toString(), Student.class);			

		//delete student
		ResponseEntity<String> response3 = restTemplate().postForEntity(new URL(BASE_URL + "/delete").toString(), response2, String.class);			
		
		//select student
		ResponseEntity<Student> response4 = restTemplate().getForEntity(new URL(BASE_URL + "/" + response.getBody().getId()).toString(), Student.class);
		
		// Assert
		assertEquals(response.getBody().getId(), response2.getBody().getId());
		assertEquals(HttpStatus.OK, response3.getStatusCode());
		assertEquals(null, response4.getBody());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
