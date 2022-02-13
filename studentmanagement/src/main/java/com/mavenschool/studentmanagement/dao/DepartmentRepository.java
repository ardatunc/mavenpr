package com.mavenschool.studentmanagement.dao;
import com.mavenschool.studentmanagement.model.Department;
import java.util.List;

public interface DepartmentRepository {
	
	Department findById(Integer id);
	List<Department> findByStudenId(Integer studentId);
	void create(Department dept);
	Department update(Department dept);
	void delete(Integer id);
	

}
