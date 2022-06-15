package com.abc.demo.courses.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="course1")
public class Course {
	@Id
//	@GeneratedValue
	private int id; 
	
	@Column(name="course_name")
	private String name;
	private String auther;
	
	public Course() {
		
	}
	
	public Course(int id, String name, String auther) {
		super();
		this.id = id;
		this.name = name;
		this.auther = auther;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuther() {
		return auther;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", auther=" + auther + "]";
	}

}
