package com.example.helloBoot.Lessons.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vehicleId;
	private String vehicleNumber;
	private String vehicleType;
	
	@OneToOne(mappedBy="vehicle" , cascade=CascadeType.ALL) //MAPPEDbY SE YHAN BATAANA PADEGA KI ALREADY MAPPED HAI , VARNA JPA DONO TABLES ME FOREIGN KEY BANAADEGA , VEHICLE ID FOREIGN KEY KRDI HAI HUMNE PERSON TABLE ME.
	private Person owner;

}
