package com.roundrocklabs.academy.manager.impl;

import java.util.List;

import com.roundrocklabs.academy.dao.ICourseDAO;
import com.roundrocklabs.academy.dao.impl.CourseDAOImpl;
import com.roundrocklabs.academy.manager.ICourseManager;
import com.roundrocklabs.academy.model.Course;

public class CourseManagerImpl implements ICourseManager {

	private ICourseDAO courseDAO = new CourseDAOImpl();

    @Override
	public void create(Course course) {
		courseDAO.create(course);
	}

    @Override
	public void update(Course course) {
		courseDAO.update(course);
	}

    @Override
	public List<Course> read(Course c) {
		return courseDAO.read(c);
	}

    @Override
	public void delete(Course course) {
		courseDAO.delete(course);
	}

}
