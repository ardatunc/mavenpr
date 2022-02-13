package com.mavenschool.studentmanagement.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Student {

	
	private Integer id;
	private String firstName;
	private String lastName;
	private Date addDate;
	
	private Set<Department> dept = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Set<Department> getDept() {
		return dept;
	}

	public void setDept(Set<Department> dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addDate=" + addDate
				+ ", dept=" + dept + "]";
	}
	
	
	
	
	
	
	
}
