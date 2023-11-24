package com.example.helloBoot.Lessons.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long personId;
	private String name;
	private String email;
	private String location;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="vehicle_id") // COLUMN KA NAAM VEHICLE_ID RKHDEGA YE FOR FOREIGN KEY IN PERSON TABLE. WE AVOID CREATION OF ANOTHER FOREIGN KEY FOR THIS RELATIONSHIP IN VEHICLE TABLE BY USING MAPPED_BY...
	private Vehicle vehicle;
	
	

}
