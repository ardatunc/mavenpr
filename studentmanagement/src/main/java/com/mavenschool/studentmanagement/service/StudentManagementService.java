package com.mavenschool.studentmanagement.service;

import java.util.List;

import com.mavenschool.studentmanagement.exception.StudentNotFoundException;
import com.mavenschool.studentmanagement.model.Student;

public interface StudentManagementService {
	List<Student> findStudent();
	List<Student> findStudent(String lastName);
	
	Student findStudent(Integer id) throws StudentNotFoundException;
	void createStudent(Student student);
	void update(Student student);
	void deleteStudent(Integer id);
	void updateStudent(Student student);
}
