package com.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.student.model.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		System.out.println("Registration");
		ModelAndView model = new ModelAndView();
		model.addObject("student", new Student());
		model.setViewName("registration");
		return model;
	}

	@RequestMapping(path = "/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@Valid @ModelAttribute Student student, BindingResult result) {
		System.out.println("addStudent" + student); // logging implement

		ModelAndView model = new ModelAndView();
		if (result.hasErrors()) {
			model.setViewName("registration");
			return model;
		} else {

			if (student.getId() != null) {
				studentService.updateStudent(student);
			} else {
				studentService.saveStudent(student);
			}
			List<Student> studentsList = studentService.getStudents();
			model.addObject("students", studentsList);
			model.setViewName("success");
			return model;
		}
	}

	@RequestMapping(path = "/updateStudent", method = RequestMethod.GET)
	public ModelAndView showEditStudentPage(@RequestParam long id) {
		ModelAndView model = new ModelAndView();
		model.addObject("student", studentService.getStudentById(id));
		model.setViewName("registration");
		return model;
	}

	@RequestMapping(path = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deletestudent(@RequestParam long id) {
		ModelAndView model = new ModelAndView();
		studentService.delete(id);
		List<Student> studentsList = studentService.getStudents();
		model.addObject("students", studentsList);
		model.setViewName("success");
		return model;
	}

}
