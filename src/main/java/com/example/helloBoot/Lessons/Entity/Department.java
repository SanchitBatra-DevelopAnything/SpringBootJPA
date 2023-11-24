package com.example.helloBoot.Lessons.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data //has all of the above.
@Entity //give this Entity annotation to make this class interact with DB.
public class Department {
	
	
	
	@Id //make departmentId as the primary key of department table.
	@GeneratedValue(strategy=GenerationType.AUTO) //auto increment.
	private long departmentId;
	private String departmentCode;
	@NotBlank(message="Please send the department name , you cant miss it!") //to activate this pom me starter-validation include karlo and controller me @Valid use karlo.
	private String departmentName;
	private String departmentAddress;
	
//	public void print()
//	{
//		System.out.println(this.departmentCode + "-" + this.departmentAddress + "-" + this.departmentName);
//	}

}
