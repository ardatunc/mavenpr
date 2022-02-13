package com.mavenschool.studentmanagement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mavenschool.studentmanagement.service.StudentManagementService;


@Controller
public class StudentManagementController {

	@Autowired
	private StudentManagementService studentManagementService;
	
	@RequestMapping("/students")
	public ModelAndView getStudents() {
		ModelAndView modavi = new ModelAndView();
		modavi.addObject("students",studentManagementService.findStudent());
		modavi.setViewName("students");
		return modavi;
	}
	
	
	@RequestMapping("/pcs")
	@ResponseBody
	public String welcome() {
		return " Welcome to Student Management System";
	}
}
