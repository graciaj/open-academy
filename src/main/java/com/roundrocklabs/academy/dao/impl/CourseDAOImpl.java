package com.roundrocklabs.academy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.roundrocklabs.academy.dao.ICourseDAO;
import com.roundrocklabs.academy.model.Course;
import com.roundrocklabs.academy.utils.HibernateUtil;

public class CourseDAOImpl implements ICourseDAO {
	private static final Log log = LogFactory.getLog(CourseDAOImpl.class);
	private static EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("oaPu");
	private static EntityManager entityManager;
	
	/**
	 * Saves the object to the database
	 * 
	 * @param course to create
	 * @return 	Course id, as stored in the database
	 */
	public void create(Course course) {
		log.debug("Course created from course: " + course.toString());
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(course);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	
	/**
	 * Updates the course
	 * 
	 * @param course object
	 */
	public void update(Course course) {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Course course2 = (Course) entityManager.find(Course.class, course.getCourse_id());
		
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
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	
	/**
	 * Finds the courses that match the partial string
	 * 
	 * @param name or partial
	 * @return List of courses that match the string or null if none found
	 */
	@SuppressWarnings("unchecked")
	public List<Course> read(Course course) {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		if (course.getCourse_id() != null) {
    		Course c = (Course) entityManager.find(Course.class, course.getCourse_id());
    		entityManager.getTransaction().commit();
    		entityManager.close();
			List<Course> cl = new ArrayList<Course>();
    		cl.add(c);
    		return cl;

		}else{        	
        	List<Course> results = (List<Course>) entityManager.find(Course.class, course.getName());
        	
        	if(results == null || results.isEmpty()){
        		results = (List<Course>) entityManager.find(Course.class, course.getDescription());
        	}
        	
        	entityManager.getTransaction().commit();
        	entityManager.close();
        	
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
	public void delete(Course course) {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.contains(course) ? course : entityManager.merge(course));
		entityManager.getTransaction().commit();
		entityManager.close();
	}



}
