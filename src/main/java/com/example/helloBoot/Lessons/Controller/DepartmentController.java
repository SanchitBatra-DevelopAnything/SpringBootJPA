package com.example.helloBoot.Lessons.Controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloBoot.Lessons.Entity.Department;
import com.example.helloBoot.Lessons.Error.DepartmentNotFoundException;
import com.example.helloBoot.Lessons.Service.DepartmentServiceInterface;
import javax.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentServiceInterface departmentService; //if it has multiple implementations , you can use @Quaifier to decide which one to pick.
	
	
	
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department dept)
	{
		//postman se we have passed everything except primary key as its auto increment we've set in entity class.
		//LOMBOK ECLIPSE ME INSTALL KARLENA.
		return departmentService.saveDepartment(dept);
	}
	
	@GetMapping("/departments")
	public List<Department> getAllDepartments()
	{
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException
	{
		//when exception is thrown it will be forwarded to RestResponseExceptionHandlerClass.
		return departmentService.getDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId)
	{
		departmentService.deleteDepartmentById(departmentId);
		return "Record deleted successfully!";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId , @RequestBody Department department) throws DepartmentNotFoundException
	{
		return departmentService.updateDepartmentById(departmentId , department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department searchByName(@PathVariable("name") String name)
	{
		return departmentService.searchByName(name); //check the custom methods we give in repo layer , JPA Repo makes dynamic methods for property based searches as well.
	}

}
