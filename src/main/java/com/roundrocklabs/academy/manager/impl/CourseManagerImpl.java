package com.roundrocklabs.academy.manager.impl;

import java.util.List;

import com.roundrocklabs.academy.dao.ICourseDAO;
import com.roundrocklabs.academy.dao.impl.CourseDAOImpl;
import com.roundrocklabs.academy.manager.ICourseManager;
import com.roundrocklabs.academy.model.Course;

public class CourseManagerImpl implements ICourseManager {

	private ICourseDAO courseDAO = new CourseDAOImpl();
	
	public Course create(Course course) {
		return courseDAO.create(course);
	}

	public void update(Course course) {
		courseDAO.update(course);
	}

	public List<Course> read(Course c) {
		return courseDAO.read(c);
	}

	public void delete(Course course) {
		courseDAO.delete(course);
	}

}
