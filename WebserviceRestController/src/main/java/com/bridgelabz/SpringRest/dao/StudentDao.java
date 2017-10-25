package com.bridgelabz.SpringRest.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import com.bridgelabz.SpringRest.model.Student;

@Component
public class StudentDao {

	private static ArrayList<Student> studentList;
	{
		Student st1 = new Student(1, "om", "cricket");
		Student st2 = new Student(2, "siddu", "football");
		Student st3 = new Student(3, "soma", "badminton");

		studentList = new ArrayList<Student>();
		studentList.add(st1);
		studentList.add(st2);
		studentList.add(st3);
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public Student getStudent(int studId) {

		for (Student s : studentList) {
			if (s.getId() == studId) {
				return s;
			}
		}
		return null;
	}

}