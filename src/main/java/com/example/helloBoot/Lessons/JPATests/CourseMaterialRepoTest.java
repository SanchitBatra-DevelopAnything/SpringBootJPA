package com.example.helloBoot.Lessons.JPATests;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.helloBoot.Lessons.Entity.Course;
import com.example.helloBoot.Lessons.Entity.CourseMaterial;
import com.example.helloBoot.Lessons.Repository.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepoTest {
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
//	@Test
//	public void saveCourseMaterial()
//	{
//		Course course = Course.builder().credit(6).title("DSA&oops").build();
//		
//		CourseMaterial cm = CourseMaterial.builder().Url("udemy.com/sanchtbatracourseonBackend").course(course).build();
//		
//		courseMaterialRepository.save(cm);
//	}
	
	@Test
	public void printAllMaterials()
	{
		List<CourseMaterial> cms = courseMaterialRepository.findAll();
		System.out.println("CMS = "+cms);
	}

}
