package com.api.student.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Students>> test() {
		
		List<Students> allStudents = studentService.getAllStudents();
		
		if(allStudents.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(allStudents));
	}
	
	
	
	//get one students handler
	@GetMapping("/test/{roll}")
	public ResponseEntity<Students> student(@PathVariable("roll") int roll) {
		Students studentByRoll = studentService.getStudentByRoll(roll);
		if(studentByRoll == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(studentByRoll));
	}
	
	//post students handler
	@PostMapping("/test")
	public ResponseEntity<Students > addStudent(@RequestBody Students stud) {
		Students addStudents = null;
		try{
			addStudents= this.studentService.addStudents(stud);
			return ResponseEntity.of(Optional.of(addStudents));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//delete students handler
	@DeleteMapping("/test/{roll}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("roll") int roll) {
		
		try {
			studentService.deleteStudent(roll);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//Update students handler
	@PutMapping("/test/{roll}")
	public ResponseEntity<Students> updateStudent(@RequestBody Students stud,@PathVariable("roll") int roll) {
		
		try {
			this.studentService.updateNameByRoll(stud,roll);
			return ResponseEntity.of(Optional.of(stud));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
		
		
	}

}
