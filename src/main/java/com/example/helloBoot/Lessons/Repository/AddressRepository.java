package com.example.helloBoot.Lessons.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.helloBoot.Lessons.Entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address , Long>{
	
	

}
