package com.example.demo.courses.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.courses.bean.Course;
import com.example.demo.courses.repository.CourseRepository;

//@RestController
@Controller
public class CourseController {
	
	
	public CourseController(CourseRepository repository) {
		super();
		this.repository = repository;
	}

	@Autowired
	private CourseRepository repository;

	@GetMapping("/courses")   
	public String getAllString (Model model) {
		
		List<Course>l=repository.findAll();
		model.addAttribute("list",l);
		return "viewData";
	}
	
	public List<Course> getCourses() {
		return repository.findAll();
	}
	
	
	public Course addCourse(Course c) {
		return repository.save(c);
	}

	@PostMapping("/saveCourses")
	public String createCourse(@RequestParam int id,@RequestParam String name,@RequestParam String author) {
		Course c=new Course(id,name,author);
		repository.save(c);
		return "sucess";
	}

	@PostMapping("/updateCourse")
	public String updateCourse(@RequestParam int id,@RequestParam String name,@RequestParam String author) {
		Optional<Course> c=repository.findById(id);
		
		if(!c.isPresent()) {
			return "noCourseExist";
		}else {
			Course cs=c.get();
			cs.setAuther(author);
			cs.setName(name);
			repository.save(cs);
		}
		return "sucess";
	}              
	
	
	@PostMapping("delete")
	public String deleteCourse(@RequestParam int id) {
		Optional<Course> c=repository.findById(id);

		if(!c.isPresent()) {
			return "noCourseExist";
		}
		repository.deleteById(id);
		return "sucess";
	}
	
	
	@RequestMapping("/")
	public String home1() {
		return "welcomeForm";
	}
	
	@RequestMapping("deletePage")
	public String deleteP() {
		return "deletePage";
	}
	
	@RequestMapping("editPage")
	public String editPage() {
		return "editPage";
	}
	
	
}