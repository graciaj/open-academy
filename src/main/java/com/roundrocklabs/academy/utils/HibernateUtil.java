package com.roundrocklabs.academy.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static SessionFactory sessionFactory = buildSessionFactory();

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        	
//        	Configuration configuration = new Configuration().configure();
//        	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//        		.applySettings(configuration.getProperties());
//        	
//        	return configuration.buildSessionFactory(builder.build());
             
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
