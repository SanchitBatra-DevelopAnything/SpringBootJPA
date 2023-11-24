package com.example.helloBoot.Lessons.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.helloBoot.Lessons.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

	//JPA REPOSITORY SE SAARE METHODS AAJAYENGE ISS INTERFACE REPO ME
	//Department pe baat ho rahi hai and primary key department pe long type ki hai isliye <Department,Long>
	
	//Agar kisi property pe search karna ho , to just create a method here and JpaRepository will take care of that search.
	//findByPropertyNameInCamelCase() should be the name of the method.
	
	public Department findByDepartmentName(String departmentName); //bas ab jaise JPA NE find by id kra hua hai , wo ye b krlega. You dont need to write code.
	
	public Department findByDepartmentNameIgnoreCase(String departmentName); //IgnoreCase rule ignores the case check.
	
	//CHECK JPA QUERY CREATION DOCUMENTATION FOR MORE.
	//these methods can help you achieve basic queries (JPQL Queries) , but if you want more advance and wanna give your own query , do this.
	
//	@Query("blah blah blah ?1 ?2") --> its a JPQL Query ?1 ?2 for inputs
//	public returnType functionName(input1 , input2);
	
	//If you cant achieve results using JPQL AS WELL, go with native queries
	
//	@Query("TYPE SQL QUERY HERE ?1 ?2" , nativeQuery=true)
//	public method(input1 , input2);
	
}
