package com.mavenschool.studentmanagement.model;



public class Department {

	private Long id;
	private String dept;
	
	
	private Student student;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", dept=" + dept + ", student=" + student + "]";
	}
	
	
	
}


