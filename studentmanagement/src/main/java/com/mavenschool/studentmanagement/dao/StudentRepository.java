package com.mavenschool.studentmanagement.dao;

import com.mavenschool.studentmanagement.model.Student;

import java.util.List;

public interface StudentRepository {

	
	List<Student> findAll();
	Student findById(Integer id);
	List<Student> findByLastName(String lastName); //metotlar asagıdaki
	
	void create(Student student);
	Student update(Student student);
	void delete(Integer id);
	
	
	
	
	
}
