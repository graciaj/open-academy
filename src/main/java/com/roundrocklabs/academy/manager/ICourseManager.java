package com.roundrocklabs.academy.manager;

import java.sql.Date;
import java.util.List;

import com.roundrocklabs.academy.model.Course;

public interface ICourseManager {

	public Integer create(Course course);
	
	public Integer create(String name, String description);
	
	public Integer create(String name);
	
	public Integer create(String name, String description, Date start_date);
	
	public void update(Course course);
	
	public Course readByID(Integer id);
	
	public List<Course> readByName(String str);
	
	public void delete(Course course);
	
}
