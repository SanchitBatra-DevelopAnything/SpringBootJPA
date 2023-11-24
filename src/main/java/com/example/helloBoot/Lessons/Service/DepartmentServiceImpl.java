package com.example.helloBoot.Lessons.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloBoot.Lessons.Entity.Department;
import com.example.helloBoot.Lessons.Error.DepartmentNotFoundException;
import com.example.helloBoot.Lessons.Repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentServiceInterface{
	
	@Autowired
	DepartmentRepository departmentRepo;

	@Override
	public Department saveDepartment(Department dept) {
		// TODO Auto-generated method stub
		return departmentRepo.save(dept); //save method from JPA repo , creates a table if not there , and saves the department.
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepo.findAll(); //findAll returns all departments automatically.		
	}

	@Override
	public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> department = departmentRepo.findById(departmentId); //findById was an optional , therefore we used .get() to fetch the actual value received.
		if(!department.isPresent())
		{
			throw new DepartmentNotFoundException();
		}
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		departmentRepo.deleteById(departmentId); //deleteById returns a void.
	}

	@Override
	public Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		try {
			Department depDB = getDepartmentById(departmentId);
			//Filter the update needed fields and set new values if needed.
			if(Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName()))
			{
				depDB.setDepartmentName(department.getDepartmentName());
			}
			
			if(Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode()))
			{
				depDB.setDepartmentCode(department.getDepartmentCode());
			}
			
			if(Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress()))
			{
				depDB.setDepartmentAddress(department.getDepartmentAddress());
			}
			
			//save depDB to database.
			return departmentRepo.save(depDB);
		}catch(DepartmentNotFoundException e)
		{
			throw e;
		}
		
	}

	@Override
	public Department searchByName(String name) {
		// TODO Auto-generated method stub
		return departmentRepo.findByDepartmentNameIgnoreCase(name);
	}
	
	
}
