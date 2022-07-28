package com.example.demo.courses.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.courses.bean.Course;


//IN JPA which entity do u want to manage,type of id
public interface CourseRepository extends JpaRepository<Course, Integer> {

	
}