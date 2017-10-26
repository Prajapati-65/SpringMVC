package com.bridgelabz.SpringRest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateStudent(@PathVariable("id") int studId, @RequestBody Student student) {

		student = StudentDaoImplementation.updateStudent(studId, student);

		if (student == null) {
			return new ResponseEntity("no customer found at id:" + studId, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(" customer found at id:" + studId, HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public ResponseEntity<Boolean> postStudent(@RequestBody Student student) {
		
		StudentDaoImplementation.postStudent(student);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(student.getId()).toUri().toString());

		return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteStudent(@PathVariable("id") int studId) {

		int id = (int) StudentDaoImplementation.deleteStudent(studId);
		if (id == 0) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
