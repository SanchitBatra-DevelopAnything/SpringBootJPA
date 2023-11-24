package com.example.helloBoot.Lessons.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {
	
	
	@Id
	@SequenceGenerator(name="course_sequence", sequenceName="course_sequence",allocationSize=1) //thats how you should do in production.
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="course_sequence")
	private Long courseId;
	private String title;
	private Integer credit;
	
	@OneToOne(
			mappedBy="course") //this is for setting up a bi-directional relationship. If we are working with course , and if we need to see courseMaterial as well , we can do this.
	//here we don't define join columns and all as we have already done that in courseMaterial , but we tell here that course property in the courseMaterial is mapping this course with the material there.
	//On a birectional mapping like this , the parent (course) will bring up child (courseMaterial) whenever fetched , but if we fetch only child , the fetchType mentioned there will tell whether we need parent also or not.
	private CourseMaterial course_material;

}
