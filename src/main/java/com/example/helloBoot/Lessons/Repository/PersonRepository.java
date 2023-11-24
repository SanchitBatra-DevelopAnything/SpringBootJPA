package com.example.helloBoot.Lessons.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.helloBoot.Lessons.Entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person , Long>{
	
	

}
