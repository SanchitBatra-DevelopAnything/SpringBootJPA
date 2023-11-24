package com.example.helloBoot.Lessons.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloBoot.Lessons.Entity.Student;
import com.example.helloBoot.Lessons.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student)
	{
		return this.studentService.saveStudent(student);
	}
	
	@GetMapping("students/email")
	public Student getStudentByEmailAddress()
	{
		String emailToBeSearched = "batrasanchit96@gmail.com";
		return studentService.getStudentByEmail(emailToBeSearched);
	}
	
	@PutMapping("students/email")
	public Student updateStudentNameByEmail()
	{
		String new_name = "Raghav Kamra";
		String email = "batrasanchit96@gmail.com";
		
		return studentService.updateStudentNameByEmail(new_name , email);
	}
		
}
