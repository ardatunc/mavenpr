package com.mavenschool.studentmanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentManagementController {

	@RequestMapping("/pcs")
	@ResponseBody
	public String welcome() {
		return " Welcome to Student Management System";
	}
}
