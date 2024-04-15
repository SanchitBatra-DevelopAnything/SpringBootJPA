package com.example.helloBoot.Lessons.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long AddressId;
	private String city;
	private String zipCode;
	private String area;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id") //foreign key child me banegi , and @JoinColumn child me hoga
	private Student student;
	

}
