package com.mavenschool.studentmanagement.dao.mem;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mavenschool.studentmanagement.dao.StudentRepository;
import com.mavenschool.studentmanagement.model.Student;


@Repository // Test İmplementasyonu
public class StudentRepositoryInMemoryImpl implements StudentRepository {
	
	private Map<Integer,Student> studentsMap = new HashMap<>();
	

	public StudentRepositoryInMemoryImpl() {
		Student student1 = new Student();
		student1.setId(112);
		student1.setFirstName("Arda");
		student1.setLastName("Tunc");
		
		Student student2 = new Student();
		student2.setId(111);
		student2.setFirstName("Sait");
		student2.setLastName("Yikilmaz");
	
		
		studentsMap.put(student1.getId(), student1);
		
		//studentsMap.put(student1.getId(), student1);
		
		//studentsMap.put(student1.getId(), student1);
		//studentsMap.put(student2.getId(), student2);
	}
	
	@Override
	public List<Student> findAll() {
		return new ArrayList<>(studentsMap.values());
	}

	@Override
	public Student findById(Integer id) {
		return studentsMap.get(id);
		
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		return studentsMap.values().stream().filter(o->o.getLastName().equals(lastName)).collect(Collectors.toList());
	}

	@Override
	public void create(Student student) {
		student.setId(1234);
		studentsMap.put(student.getId(),student);
		

	}

	@Override
	public Student update(Student student) {
		studentsMap.replace(student.getId(), student);
		return student;
	}

	@Override
	public void delete(Integer id) {
		studentsMap.remove(id);

	}

}
