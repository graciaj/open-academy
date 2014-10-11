package com.roundrocklabs.academy.manager.impl;

import java.sql.Date;
import java.util.List;

import com.roundrocklabs.academy.dao.ICourseDAO;
import com.roundrocklabs.academy.dao.impl.CourseDAOImpl;
import com.roundrocklabs.academy.manager.ICourseManager;
import com.roundrocklabs.academy.model.Course;

public class CourseManagerImpl implements ICourseManager {

	private ICourseDAO courseDAO = new CourseDAOImpl();
	
	@Override
	public Integer create(Course course) {
		return courseDAO.create(course);
	}

	@Override
	public Integer create(String name, String description) {
		return courseDAO.create(name, description);
	}

	@Override
	public Integer create(String name) {
		return courseDAO.create(name);
	}

	@Override
	public Integer create(String name, String description, Date start_date) {
		return courseDAO.create(name, description, start_date);
	}

	@Override
	public void update(Course course) {
		courseDAO.update(course);
	}

	@Override
	public Course readByID(Integer id) {
		return courseDAO.readByID(id);
	}

	@Override
	public List<Course> readByName(String str) {
		return courseDAO.readByName(str);
	}

	@Override
	public void delete(Course course) {
		courseDAO.delete(course);
	}

}
