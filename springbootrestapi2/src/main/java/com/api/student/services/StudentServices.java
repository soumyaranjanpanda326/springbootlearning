package com.api.student.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.student.entities.Students;

@Service
public class StudentServices {
	
	private static List<Students> students =  new ArrayList<Students>();
	
	
	static {
		students.add(new Students(12,"Soumya","D"));
		students.add(new Students(13,"Ranjan","E"));
		students.add(new Students(14,"Panda","F"));
		students.add(new Students(15,"Som","A"));
	}
	
	// to get all students
	public List<Students> getAllStudents() {
		return students;
	}
	
	//to get students by roll number
	public Students getStudentByRoll(int roll) {
		return students.stream().filter(e->e.getRoll()==roll).findFirst().get();
	}
	
	//to add a student
	public Students addStudents(Students s){
		students.add(s);
		return s;
	}
	
//	to delete a student 
	public void deleteStudent(int roll) {
		students = students.stream().filter(s->s.getRoll()!=roll).collect(Collectors.toList());
	}
	
//	to update a student
	public void updateNameByRoll(Students stud,int roll) {
		students = students.stream().map(s->{
			if(s.getRoll() == roll) {
				s.setName(stud.getName());
				s.setSec(stud.getSec());
			}
			return s;
		}).collect(Collectors.toList());
	}

}
