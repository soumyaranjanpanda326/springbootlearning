package com.api.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.student.entities.Students;
import com.api.student.services.StudentServices;



@RestController
public class StudentController {
	
	@Autowired
	StudentServices studentService;
	
	//get all students handler
	@GetMapping("/test")
	public List<Students>test() {
		return this.studentService.getAllStudents();
	}
	//get one students handler
	@GetMapping("/test/{roll}")
	public Students student(@PathVariable("roll") int roll) {
		return this.studentService.getStudentByRoll(roll);
	}
	
	//post students handler
	@PostMapping("/test")
	public Students addStudent(@RequestBody Students stud) {
		Students addStudents = this.studentService.addStudents(stud);
		return addStudents;
		
	}
	
	//delete students handler
	@DeleteMapping("/test/{roll}")
	public void deleteStudent(@PathVariable("roll") int roll) {
		this.studentService.deleteStudent(roll);
	}
	
	//Update students handler
	@PutMapping("/test/{roll}")
	public Students updateStudent(@RequestBody Students stud,@PathVariable("roll") int roll) {
		this.studentService.updateNameByRoll(stud,roll);
		
		return stud;
	}

}
