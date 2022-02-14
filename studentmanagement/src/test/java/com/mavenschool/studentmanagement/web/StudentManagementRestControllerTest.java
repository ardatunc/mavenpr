package com.mavenschool.studentmanagement.web;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import com.mavenschool.studentmanagement.model.Student;

public class StudentManagementRestControllerTest {
	private RestTemplate restTemplate;

	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testGetStudentById() {
		ResponseEntity<Student> response = restTemplate.getForEntity("http://localhost:8080/rest/student/0", Student.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("Arda"));
	}

	@Test
	public void testGetStudentsByLastName() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/Student?ln=Yikilmaz",
				List.class);

		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		List<Map<String, String>> body = response.getBody();

		List<String> firstNames = body.stream().map(e -> e.get("firstName")).collect(Collectors.toList());

		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Arda"));
	}
	
	@Test
	public void testGetStudents() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/Students", List.class);
		List<Map<String,String>> body = response.getBody();

		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		
		List<String> firstNames = body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
		
		MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Kenan", "Hümeyra", "Salim", "Muammer"));
	}
	
	@Test
	public void testCreateStudent() {
		Student Student = new Student();
		Student.setFirstName("Metehan");
		Student.setLastName("Yücel");

		RestTemplate restTemplate = new RestTemplate();
		URI location = restTemplate.postForLocation("http://localhost:8080/rest/Student", Student);

		Student Student2 = restTemplate.getForObject(location, Student.class);

		MatcherAssert.assertThat(Student2.getFirstName(), Matchers.equalTo(Student.getFirstName()));
		MatcherAssert.assertThat(Student2.getLastName(), Matchers.equalTo(Student.getLastName()));
	}
}