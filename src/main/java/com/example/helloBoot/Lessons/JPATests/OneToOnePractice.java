package com.example.helloBoot.Lessons.JPATests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.helloBoot.Lessons.Entity.Person;
import com.example.helloBoot.Lessons.Entity.Vehicle;
import com.example.helloBoot.Lessons.Repository.PersonRepository;
import com.example.helloBoot.Lessons.Repository.VehicleRepository;

@SpringBootTest
public class OneToOnePractice {
	
	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Autowired
	private PersonRepository personRepo;
	
	
//	@Test
//	public void savePerson()
//	{
//		Person p = Person.builder().name("SANCHIT BATRA").email("batrasanchit06@gmail.com").location("ROHINI").build();
//		Vehicle v = Vehicle.builder().vehicleType("car").vehicleNumber("DL11CB2247").owner(p).build();
//		
//		p.setVehicle(v);
//		
//		personRepo.save(p);
//	}
	
	@Test
	public void saveVehicle()
	{
		Person p = Person.builder().name("ANCHAL BATRA").email("anchalb4@gmail.com").location("lajpat nagar").build();
		Vehicle v = Vehicle.builder().vehicleType("car").vehicleNumber("DL11CQ4821").owner(p).build();
		
		p.setVehicle(v);
		
		vehicleRepo.save(v);
	}

}
