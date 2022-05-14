package com.mg.obs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mg.obs.entity.Student;
import com.mg.obs.repository.StudentRepository;
import com.mg.obs.service.StudentService;

@SpringBootTest
public class StudentServiceMockTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks // auto inject
    private StudentService studentService = new StudentService();

    @BeforeEach
    void setMockOutput() {
    	Student student = new Student(99, "", "", "", 1, 1, "");    	
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student));
    }
    
    @Test
    void getAll() {
    	Student student = new Student(99, "", "", "", 1, 1, "");
        assertEquals(Arrays.asList(student), studentService.getAll());
    }

}