package com.example.helloBoot.Lessons.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.helloBoot.Lessons.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long>{
	
	public Student findByFirstNameIgnoreCase(String studentName);
	
	public List<Student> findByGuardianName(String name); //Guradian----ThenPropertyNameinsideGuardian.
	
	@Query("select s from Student s where s.emailId=?1") //note its not tbl_student as JPQL Queries are defined based on our classes and not on tables.
	public Student getStudentByEmailAddress(String emailId); //JPQL QUERIES ARE DEFINED BASED ON YOUR CLASSES , NOT BASED ON TABLES IN DB.//native queries are table based.
	
	@Query(
			value="select * from tbl_student s where s.email_address= :emailId", //you can also use ?1 here , but its good to use named parameters.
			nativeQuery=true
			)
	public Student getStudentByEmailNative(@Param("emailId") String emailId);
	
	//some update methods in repo layer , update firstName where email_address=?1;
	
	
	@Modifying //modifying query is used to update/insert/delete anything.
	@Query(value="update tbl_student set first_name=?1 where email_address=?2" , nativeQuery=true)
	public int updateStudentNameByEmailId(String firstName , String emailId);
	

}
