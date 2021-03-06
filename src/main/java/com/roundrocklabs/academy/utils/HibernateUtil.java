/**
 * 
 */

package com.roundrocklabs.academy.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.roundrocklabs.academy.model.*;

@SuppressWarnings("deprecation")
public class HibernateUtil {
    
    private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//            return new Configuration().configure().buildSessionFactory();
        	
        	return new AnnotationConfiguration()
        		.addPackage("com.roundrocklabs.academy.model")
        		.addAnnotatedClass(Academy.class)
        		.addAnnotatedClass(Course.class)
        		.addAnnotatedClass(Parent.class)
        		.addAnnotatedClass(Person.class)
        		.addAnnotatedClass(Room.class)
        		.addAnnotatedClass(Site.class)
        		.addAnnotatedClass(Staff.class)
        		.addAnnotatedClass(Student.class)
        		.addAnnotatedClass(Teacher.class)
        		.configure()
        		.buildSessionFactory();
             
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
		
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
