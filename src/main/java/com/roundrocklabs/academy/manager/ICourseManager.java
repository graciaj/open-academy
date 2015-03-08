package com.roundrocklabs.academy.manager;

import java.util.List;

import com.roundrocklabs.academy.model.Course;

public interface ICourseManager {

    public void create(Course c);

    public void update(Course c);

    public List<Course> read(Course c);

    public void delete(Course c);

}
