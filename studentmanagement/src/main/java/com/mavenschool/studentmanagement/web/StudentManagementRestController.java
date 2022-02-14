package com.mavenschool.studentmanagement.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mavenschool.studentmanagement.exception.StudentNotFoundException;
import com.mavenschool.studentmanagement.model.Student;
import com.mavenschool.studentmanagement.service.StudentManagementService;


@RestController
@RequestMapping("/rest")
public class StudentManagementRestController {
	
	@Autowired
	private StudentManagementService studentManagementService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/students")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentManagementService.findStudent();
		return ResponseEntity.ok(students);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/student/{id}")
	public ResponseEntity<?> getStudent(@PathVariable("id") Integer id) {
		try {
			Student student = studentManagementService.findStudent(id);
			return ResponseEntity.ok(student);
		} catch (StudentNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/student")
	public ResponseEntity<List<Student>> getStudents(@RequestParam("ln") String lastName) {
		List<Student> students = studentManagementService.findStudent(lastName);
		return ResponseEntity.ok(students);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/student")
	public ResponseEntity<URI> createStudent(@RequestBody Student student) {
		try {
			studentManagementService.createStudent(student);
			Integer id = student.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/student/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") Integer id, @RequestBody Student studentRequest) {
		try {
			Student student = studentManagementService.findStudent(id);
			student.setFirstName(studentRequest.getFirstName());
			student.setLastName(studentRequest.getLastName());
			studentManagementService.updateStudent(student);
			return ResponseEntity.ok().build();
		} catch (StudentNotFoundException ex) {
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Integer id) {
		try {
			studentManagementService.deleteStudent(id);
			return ResponseEntity.ok().build();
		} catch (StudentNotFoundException ex) {
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}