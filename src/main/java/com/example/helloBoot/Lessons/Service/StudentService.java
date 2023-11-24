package com.example.helloBoot.Lessons.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloBoot.Lessons.Entity.Student;
import com.example.helloBoot.Lessons.Error.DepartmentNotFoundException;
import com.example.helloBoot.Lessons.Repository.StudentRepository;

@Service
public class StudentService {
	
	
	@Autowired
	StudentRepository studentRepo;

	
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student); //save method from JPA repo , creates a table if not there , and saves the department.
	}

	
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll(); //findAll returns all departments automatically.		
	}

	
	public Student getStudentById(Long studentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Student> department = studentRepo.findById(studentId); //findById was an optional , therefore we used .get() to fetch the actual value received.
		if(!department.isPresent())
		{
			throw new DepartmentNotFoundException();
		}
		return department.get();
	}

	
	public void deleteStudentById(Long departmentId) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(departmentId); //deleteById returns a void.
	}

	
	public Student updateStudentById(Long studentId, Student student) throws Exception {
		// TODO Auto-generated method stub
		try {
			Student studentDB = getStudentById(studentId);
			//Filter the update needed fields and set new values if needed.
			if(Objects.nonNull(student.getFirstName()) && !"".equals(student.getFirstName()))
			{
				studentDB.setFirstName(student.getFirstName());
			}
			
			if(Objects.nonNull(student.getLastName()) && !"".equals(student.getLastName()))
			{
				studentDB.setLastName(student.getLastName());
			}
			
			if(Objects.nonNull(student.getEmailId()) && !"".equals(student.getEmailId()))
			{
				studentDB.setEmailId(student.getEmailId());
			}
			
			//save depDB to database.
			return studentRepo.save(studentDB);
		}catch(Exception e)
		{
			throw e;
		}
		
	}

	
	public Student searchByName(String name) {
		// TODO Auto-generated method stub
		return studentRepo.findByFirstNameIgnoreCase(name);
	}
	
	public Student getStudentByEmail(String emailId)
	{
		return studentRepo.getStudentByEmailAddress(emailId);
	}
	
	@Transactional
	public Student updateStudentNameByEmail(String new_name , String email)
	{
		int aa = studentRepo.updateStudentNameByEmailId(new_name, email);
		try {
			return getStudentById(1L);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
		}
		
		return null;
		
	}

}
