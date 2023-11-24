package com.example.helloBoot.Lessons.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString(exclude="course") //abhi ke liye hatwaya hai usne , cuz toString calling course as well.
public class CourseMaterial {
	

	@Id
	@SequenceGenerator(name="courseMaterial_sequence", sequenceName="courseMaterial_sequence",allocationSize=1) //thats how you should do in production.
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="courseMaterial_sequence")
	private Long courseMaterialId;
	private String Url;

	//courseMaterial can't exist without a course , therefore we keep course here with one to one map.
	
	@OneToOne(
			cascade=CascadeType.ALL) //cascade defines if I insert a courseMaterial , course will also be inserted with it & if I delete a courseMaterial , course should also be deleted. By default , it will only map on an already existing course.
	//fetch defines 2 types : EAGER = WHEN I FETCH MATERIAL , I also want course , LAZY MEANS when i fetch material i only want material.
	@JoinColumn(
			name = "course_id" , referencedColumnName="courseId") //courseId prop from course is being mapped as Foreign Key here. and column name set to course_id.
	private Course course;
}
