package com.bridgelabz.SpringRest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.SpringRest.dao.StudentDao;
import com.bridgelabz.SpringRest.model.Student;

@RestController
public class StudentController {

	@Autowired
	StudentDao StudentDaoImplementation;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ArrayList<Student> getStudentList() {
		return StudentDaoImplementation.getStudentList();
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("id") int studId) {

		Student student = StudentDaoImplementation.getStudent(studId);
		return student;

	}
}
