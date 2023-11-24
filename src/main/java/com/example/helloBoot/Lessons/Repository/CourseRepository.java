package com.example.helloBoot.Lessons.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.helloBoot.Lessons.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course , Long>{

}
