package com.student.dao;

import com.student.model.Student;

//@Repository
public class StudentRepositoryImpl  {

	public void saveStudent(Student student) {
		System.out.println("Student RespositoryImpl"+student);
	}
}
