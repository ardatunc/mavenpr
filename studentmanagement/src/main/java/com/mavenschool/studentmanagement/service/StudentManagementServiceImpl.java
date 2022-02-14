package com.mavenschool.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mavenschool.studentmanagement.dao.StudentRepository;
import com.mavenschool.studentmanagement.exception.StudentNotFoundException;
import com.mavenschool.studentmanagement.model.Student;

@Service
public class StudentManagementServiceImpl implements StudentManagementService {

	
	private StudentRepository studentRepository;
	
	@Autowired
	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	
	@Override
	public List<Student> findStudent() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> findStudent(String lastName) {
		return studentRepository.findByLastName(lastName);
	}
	
	@Override
	public Student findStudent(Integer id) throws StudentNotFoundException {
		Student student = studentRepository.findById(id);
		if(student == null) throw new StudentNotFoundException("Student not found.");
		return null;
	}

	@Override
	public void createStudent(Student student) {
		studentRepository.create(student);
	}

	@Override
	public void update(Student student) {
		studentRepository.update(student);

	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepository.delete(id);

	}


	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

}
