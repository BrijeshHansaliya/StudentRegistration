package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {

	public void saveStudent(Student student);
	
	public void delete(long id);
	
	public List<Student> getStudents();
	
	public void updateStudent(Student student);
	
	public Student getStudentById(long id);
}
