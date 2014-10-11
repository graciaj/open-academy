package com.roundrocklabs.academy.dao.impl;

import java.sql.Date;
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
	public Integer create(Course course) {
		log.debug("Course created from course: " + course.toString());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(course);
		session.getTransaction().commit();
		return id;
	}

	
	/**
	 * Creates a new object and saves it to the database
	 * 
	 * @param name	of the course
	 * @param description	saved if included
	 * @return	course id, as stored in the database
	 */
	public Integer create(String name, String description) {
		Course course = new Course();
		course.setName(name);
		course.setDescription(description);
		return create(course);
	}


	/**
	 * Creates a new object from the name
	 * 
	 * @param name of the course
	 * @return course id
	 */
	public Integer create(String name) {
		Course course = new Course();
		course.setName(name);
		return create(course);
	}

	
	
	/**
	 * Creates a new object and saves it to the database
	 * 
	 * @param name	of the course
	 * @param description	saved if included
	 * @param start_date of the course
	 * @return	course id, as stored in the database
	 */
	public Integer create(String name, String description, Date start_date) {
		Course course = new Course();
		course.setName(name);
		course.setDescription(description);
		course.setStart_date(start_date);
		return create(course);
	}
	
	/**
	 * Updates the course
	 * 
	 * @param course object
	 */
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
	 * Finds a course in the database by the course id
	 * 
	 * @param id of the course
	 * @return course object that matches the id
	 */
	public Course readByID(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		return (Course) session.load(Course.class, id);
	}

	
	/**
	 * Finds the courses that match the partial string
	 * 
	 * @param name or partial
	 * @return List of courses that match the string or null if none found
	 */
	public List<Course> readByName(String str) {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from course c where str(c.name) like :name")
    			.setParameter("name", str);
    	
    	List<Course> results = query.list();
    	
    	if(results == null || results.isEmpty()){
    		Query query2 =session.createQuery("from course c where str(c.description) like :desc")
        			.setParameter("desc", str);
    		results = query2.list();
    	}
    	
    	session.getTransaction().commit();
    	
    	if(results == null || results.isEmpty()){
    		return null;
    	}else{
    		return results;
    	}
	}

	
	/**
	 * Deletes the course
	 * 
	 * @param object to delete
	 */
	public void delete(Course course) {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	Course db_course = (Course) session.load(Course.class, course.getCourse_id());
    	session.delete(db_course);
    	session.getTransaction().commit();
	}



}
