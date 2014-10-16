package com.roundrocklabs.academy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.roundrocklabs.academy.dao.ICourseDAO;
import com.roundrocklabs.academy.model.Course;
import com.roundrocklabs.academy.utils.HibernateUtil;

public class CourseDAOImpl implements ICourseDAO {
	private static final Log log = LogFactory.getLog(CourseDAOImpl.class);
	
	/**
	 * Saves the object to the database
	 * 
	 * @param course to create
	 * @return 	Course id, as stored in the database
	 */
	@Override
	public Course create(Course course) {
		log.debug("Course created from course: " + course.toString());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(course);
		session.getTransaction().commit();
		course.setCourse_id(id);
		return course;
	}

	
	/**
	 * Updates the course
	 * 
	 * @param course object
	 */
	@Override
	public void update(Course course) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Course course2 = (Course) session.load(Course.class, course.getCourse_id());
		
		if( !course.getName().isEmpty() || !(course.getName() == null) ){
			course2.setName(course.getName());
		}
		
		if ( !course.getDescription().isEmpty() || !(course.getDescription() == null)){
			course2.setDescription(course.getDescription());
		}
		
		if( !(course.getStart_date() == null) ){
			course2.setStart_date(course.getStart_date());
		}
		
		if( !(course.getRetire_date() == null) ){
			course2.setRetire_date(course.getRetire_date());
		}
		
		session.getTransaction().commit();
		
	}

	
	/**
	 * Finds the courses that match the partial string
	 * 
	 * @param name or partial
	 * @return List of courses that match the string or null if none found
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Course> read(Course course) {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();

		if (course.getCourse_id() != null) {
    		Course c = (Course) session.load(Course.class, course.getCourse_id());
        	session.getTransaction().commit();
			List<Course> cl = new ArrayList<Course>();
    		cl.add(c);
    		return cl;
    	}else{
        	Query query = session.createQuery("from course c where str(c.name) like :name")
        			.setParameter("name", course.getName());
        	
        	List<Course> results = query.list();
        	
        	if(results == null || results.isEmpty()){
        		Query query2 =session.createQuery("from course c where str(c.description) like :desc")
            			.setParameter("desc", course.getDescription());
        		results = query2.list();
        	}
        	
        	session.getTransaction().commit();
        	
        	if(results == null || results.isEmpty()){
        		return null;
        	}else{
        		return results;
        	}
    	}
		
	}

	
	/**
	 * Deletes the course
	 * 
	 * @param object to delete
	 */
	@Override
	public void delete(Course course) {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	Course db_course = (Course) session.load(Course.class, course.getCourse_id());
    	session.delete(db_course);
    	session.getTransaction().commit();
	}



}
