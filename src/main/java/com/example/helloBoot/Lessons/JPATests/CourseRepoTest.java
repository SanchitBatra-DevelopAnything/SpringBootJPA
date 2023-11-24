package com.example.helloBoot.Lessons.JPATests;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.helloBoot.Lessons.Entity.Course;
import com.example.helloBoot.Lessons.Repository.CourseRepository;

@SpringBootTest
public class CourseRepoTest {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourses()
	{
		List<Course> courses = courseRepository.findAll();
		System.out.println("COURSES -> " + courses);
	}
	
//	@Test
//	@Modifying
//	public void deleteCourse()
//	{
//		courseRepository.deleteAll();
//	}

}
