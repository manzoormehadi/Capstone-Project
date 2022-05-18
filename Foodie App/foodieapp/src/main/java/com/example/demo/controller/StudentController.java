package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/webapp3/student")
public class StudentController {

	@Autowired
	private Student student;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public String index() {
		return "WebApp3 controller accessible";
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	@PostMapping("/{studentname}")
	public ResponseEntity<Student> addStudent(@PathVariable("studentname") String studentname) {
		
		student.setStudentName(studentname);
		return new ResponseEntity<Student>(studentService.addStudent(student),HttpStatus.CREATED);
	}
	
}
