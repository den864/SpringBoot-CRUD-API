package com.abc.demo.courses.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.demo.courses.bean.Course;
import com.abc.demo.courses.repository.CourseRepository;

@RestController
public class CourseController {
	@Autowired
	private CourseRepository repository;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
//		return Arrays.asList(new Course(1,"learn java","dhaval"), new Course(2,"cpp", "aa"));
		return repository.findAll();
	}
	
	@GetMapping("courses/{id}")
	public Course getOneCourses(@PathVariable int id){
		Optional<Course> c=repository.findById(id);
		if(!c.isPresent()) {
			throw new RuntimeException("course not found with id "+id);
		}
		return c.get();
	}
	
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course c) {
		repository.save(c);
	}
	
	@PutMapping("courses/{id}")
	public void updateCourse(@PathVariable int id,@RequestBody Course c) {
		repository.save(c);
	}
	
	@DeleteMapping("courses/{id}")
	public void deleteCourse(@PathVariable int id) {
		repository.deleteById(id);
	}
	
}
