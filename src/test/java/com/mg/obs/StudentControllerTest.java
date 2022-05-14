package com.mg.obs;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mg.obs.controller.StudentController;
import com.mg.obs.entity.Student;
import com.mg.obs.service.StudentService;
import com.mg.obs.service.UtilService;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;

	@MockBean
	StudentService studentService;
	@MockBean
	UtilService utilService;

	Student RECORD_1 = new Student(1, "", "Mustafa", "", 1, 1, "");
	Student RECORD_2 = new Student(2, "", "Ali", "", 1, 1, "");
	Student RECORD_3 = new Student(2, "", "Riza", "", 1, 1, "");

	@Test
	public void getAllRecords_success() throws Exception {
		List<Student> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

		Mockito.when(studentService.getAll(null, null, null, 0, 0, null)).thenReturn(records);

		mockMvc.perform(MockMvcRequestBuilders.get("/students").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
//				.andExpect(jsonPath("$", hasSize(3)))
//				.andExpect(jsonPath("$[1].adi", is("Ali")));
	}

	@Test
	public void getById_success() throws Exception {
		Mockito.when(studentService.findById(RECORD_1.getId())).thenReturn(RECORD_1);

		mockMvc.perform(MockMvcRequestBuilders.get("/students/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
//				.andExpect(jsonPath("$", notNullValue()))
//				.andExpect(jsonPath("$.adi", is("Mustafa")));
	}

	@Test
	public void save_success() throws Exception {
		Student record = new Student(0, "433", "Mustafa", "Gökkurt", 1, 1, "");

		Mockito.when(studentService.save(record)).thenReturn(record);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/students/save")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(record));

		mockMvc.perform(mockRequest)
				.andExpect(status().isCreated());
//				.andExpect(jsonPath("$", notNullValue()))
//				.andExpect(jsonPath("$.adi", is("Mustafa")))
//				.andExpect(jsonPath("$.soyadi", is("Gökkurt")));
	}

	@Test
	public void delete_success() throws Exception {
		Mockito.when(studentService.findById(RECORD_2.getId())).thenReturn(RECORD_2);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/students/delete")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(RECORD_2));
		
		mockMvc.perform(mockRequest)
				.andExpect(status().isOk());
	}

//	@Test
//	public void delete_notFound() throws Exception {
//		Mockito.when(studentService.findById(500)).thenReturn(null);
//
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/students/delete")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON)
//				.content(this.mapper.writeValueAsString(null));
//		
//		mockMvc.perform(mockRequest)
//				.andExpect(status().isBadRequest())
//				.andExpect(result -> assertTrue(result.getResolvedException() instanceof NullPointerException))
//				.andExpect(result -> assertEquals("student with ID 500 does not exist.",
//						result.getResolvedException().getMessage()));
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
