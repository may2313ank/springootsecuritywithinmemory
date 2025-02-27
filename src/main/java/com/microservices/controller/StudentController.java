package com.microservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.Student;

@RestController
public class StudentController {

	public List<Student> student= Arrays.asList(new Student(101,"mayank",87), new Student(102,"ravi",67));
	
	@GetMapping("/student")
	public List<Student> getStudent(){
		return student;
	}
}
