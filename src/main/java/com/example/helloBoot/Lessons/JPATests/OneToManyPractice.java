package com.example.helloBoot.Lessons.JPATests;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.helloBoot.Lessons.Entity.Address;
import com.example.helloBoot.Lessons.Entity.Guardian;
import com.example.helloBoot.Lessons.Entity.Student;
import com.example.helloBoot.Lessons.Repository.AddressRepository;
import com.example.helloBoot.Lessons.Repository.StudentRepository;

@SpringBootTest
public class OneToManyPractice {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
//	@Test
//	public void saveStudent()
//	{
//		//saving student will also create addresses automatically as we have used cascade all.
//		//deleting student would also delete all addresses associated with student due to cascade all.
//		ArrayList<Address> addressList = new ArrayList<>();
//		
//		Address add1 = Address.builder().city("SAHIBABAD").area("GHAZIABAD").zipCode("110082").build();
//		Address add2 = Address.builder().city("RANI BAGH").area("NEW DELHI").zipCode("110064").build();
//		Address add3 = Address.builder().city("Rohini").area("NEW DELHI").zipCode("110085").build();
//		
//		
//		
//		addressList.add(add1);
//		addressList.add(add2);
//		addressList.add(add3);
//		
//		
//		Guardian g = Guardian.builder().name("SURENDER").email("surendermonga@gmail.com").mobile("9868621199").build();
//		Student s = Student.builder().firstName("ANISH").lastName("MONGA").emailId("anishmonga@gmail.com").guardian(g).addresses(addressList).build();
//		
//		add1.setStudent(s);
//		add2.setStudent(s);
//		add3.setStudent(s);
//		
//		studentRepo.save(s);
//		
//		//addressRepo.save(add1); //See we dint give addressList on student , but this address had student associated with it so it got created!
//		
//		//yaar yahan humne address table me student_id banaaya hai na DB me , to its mandatory to add student while we create address!!!!
//	}
	
	@Test
	public void deleteAddress()
	{
		addressRepo.deleteById(25L); // ek address delete krunga , to student b udjayga as i have cascade all , jab student udega to saare address udjayenge due to cascade all , isliye just apply cascade all on student class here.
	}
	
//	@Test
//	public void deleteStudent()
//	{
//		studentRepo.deleteById(8L);
//	}

}
