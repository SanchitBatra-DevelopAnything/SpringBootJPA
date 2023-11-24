package com.example.helloBoot.Lessons.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//use this in prod apps where table is already created in DB and you need to point this class to that table. create if not exists. do work if exists.
@Table(name="tbl_student",
uniqueConstraints=@UniqueConstraint(
		name="email_id_unique" , columnNames="email_address")
) 
public class Student {
	
	
	@Id
	@SequenceGenerator(name="student_sequence", sequenceName="student_sequence",allocationSize=1) //thats how you should do in production.
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="student_sequence")
	private Long studentId;
	private String firstName;
	private String lastName;
	
	@Column(name="email_address" , nullable=false) //give specefic column name , other wise it will seperate camelCases with _ , also tell if null allowed or not default nullable=true/
	private String emailId;
	
	@Embedded
	private Guardian guardian; //embeddable guardian is embedded into students table.
	
	
	//REQUEST BODY WOULD BE LIKE FROM POSTMAN....
//	{
//	    "firstName" : "Sanchit",
//	    "lastName" : "Batra",
//	    "emailId" : "batrasanchit96@gmail.com",
//	    "guardian" : {
//	        "name" : "Nikhil" , 
//	        "mobile" :"9999565994",
//	        "email" : "anchalb4@gmail.com"
//	    }
//	}
	
	@OneToMany(mappedBy="student" , cascade=CascadeType.ALL) //mapped by property student in address class.
	private List<Address> addresses;
	

}
