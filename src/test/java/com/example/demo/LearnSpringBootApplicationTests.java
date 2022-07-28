package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.OffsetTimeAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.courses.bean.Course;
import com.example.demo.courses.controller.CourseController;
import com.example.demo.courses.repository.CourseRepository;

@SpringBootTest
class LearnSpringBootApplicationTests {
	
	private CourseController controller;
	
	@MockBean
	private CourseRepository repo;
	
	@BeforeEach
	void setup() {
		this.controller=new CourseController(this.repo);
	}
	
	
	
	@Test
	void getCourseTest() {
		when(repo.findAll()).thenReturn(Stream.of(new Course(122,"aa","bb"),new Course(123,"cd","cc")).collect(Collectors.toList()));
		assertEquals(2,controller.getCourses().size());
	}

	 
	@Test
	public void saveCourseTest() {
		Course c=new Course(33,"aaa","bbb");
		when(repo.save(c)).thenReturn(c);
		assertEquals(c, controller.addCourse(c));
	}
	
}
