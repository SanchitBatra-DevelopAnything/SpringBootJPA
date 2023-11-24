package com.example.helloBoot.Lessons.Entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@AttributeOverrides({
	@AttributeOverride(
			name = "name",column=@Column(name="guardian_name") //mapping properties here with the actual column names in students db. (as guardian is embedded into student and not a table itself.)
			),
	@AttributeOverride(
			name = "email",column=@Column(name="guardian_email")
			),
	@AttributeOverride(
			name = "mobile",column=@Column(name="guardian_mobile")
			)
})
public class Guardian {

	private String name;
	private String email;
	private String mobile;
	
	// guardian itself is not an identity , but a part of student table itself in my design.
	//therefore i am embedding guardian into student class.
	//To match properties of guardian to column names of student i will use attribute overrides.
	
}
