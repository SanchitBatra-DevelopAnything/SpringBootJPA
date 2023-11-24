package com.example.helloBoot.Lessons.Service;

import java.util.List;

import com.example.helloBoot.Lessons.Entity.Department;
import com.example.helloBoot.Lessons.Error.DepartmentNotFoundException;

public interface DepartmentServiceInterface {

	public Department saveDepartment(Department dept);

	public List<Department> getAllDepartments();

	public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException;

	public Department searchByName(String name);

}
