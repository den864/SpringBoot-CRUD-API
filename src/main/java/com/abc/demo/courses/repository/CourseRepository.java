package com.abc.demo.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.abc.demo.courses.bean.Course;


//IN JPA which entity do u want to manage,type of id
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
}
 