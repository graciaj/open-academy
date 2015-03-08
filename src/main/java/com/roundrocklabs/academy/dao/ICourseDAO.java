package com.roundrocklabs.academy.dao;

import java.util.List;

import com.roundrocklabs.academy.model.Course;

public interface ICourseDAO {

    public void create(Course a);

    public void update(Course a);

    public List<Course> read(Course a);

    public void delete(Course a);

}
