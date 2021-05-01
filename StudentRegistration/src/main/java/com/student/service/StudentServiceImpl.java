package com.student.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentRepository;
import com.student.entity.HobbyEntity;
import com.student.entity.StudentEntity;
import com.student.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void saveStudent(Student student) {
		
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setId(student.getId());
		studentEntity.setName(student.getName());
		studentEntity.setCity(student.getCity());
		studentEntity.setEmailId(student.getEmailId());
		studentEntity.setCourse(student.getCourse());
		studentEntity.setGender(student.getGender());
		
		if (student.getHobby() != null) {
			Set<HobbyEntity> entity = new HashSet<>();
			for (int i=0; i<student.getHobby().length; i++) {
				HobbyEntity hobby = new HobbyEntity();
				hobby.setGame(student.getHobby()[i]);
				hobby.setStudent(studentEntity);
				entity.add(hobby);
			}
			studentEntity.setHobby(entity);
		}
		studentRepository.save(studentEntity);
	}

	public void delete(long id) {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setId(id);
        studentRepository.delete(studentEntity);
    }

	@Override
	public List<Student> getStudents() {
		List<StudentEntity> studentEntities = studentRepository.findAll();
		List<Student> studentsList = new ArrayList<>();
		for (StudentEntity studentEntity : studentEntities) {
			Student student = getModelFromEntity(studentEntity);
			studentsList.add(student);
		}
		return studentsList;
	}

	@Override
	public void updateStudent(Student student) {
		saveStudent(student);
	}

	@Override
	public Student getStudentById(long id) {
		StudentEntity studentEntity = studentRepository.findById(id).get();
		Student student = getModelFromEntity(studentEntity);
		return student;
	}

	public Student getModelFromEntity(StudentEntity studentEntity) {
		Student student = new Student();
		student.setId(studentEntity.getId());
		student.setName(studentEntity.getName());
		student.setCity(studentEntity.getCity());
		student.setEmailId(studentEntity.getEmailId());
		student.setCourse(studentEntity.getCourse());
		student.setGender(studentEntity.getGender());
		
		Set<String> hobbySet = new HashSet<String>();
		for (HobbyEntity hobbyEntity: studentEntity.getHobby()) {
			hobbySet.add(hobbyEntity.getGame());
		}
		student.setHobby(hobbySet.toArray(new String[hobbySet.size()]));
		return student;
	}
	
}	