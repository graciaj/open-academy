/**
 * @author Lehi Gracia
 * @copyright 2014 Lehi Gracia
 */


package com.roundrocklabs.academy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.roundrocklabs.academy.dao.IAcademyDAO;
import com.roundrocklabs.academy.model.Academy;


public class AcademyDAOImpl implements IAcademyDAO {
	private static final Log log = LogFactory.getLog(AcademyDAOImpl.class);
	private static EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("oaPu");
	private static EntityManager entityManager;
	
//	public AcademyDAOImpl(){}
	/**
	 * Saves the Academy object to the database
	 * 
	 * @param academy	Academy object to create
	 * 
	 */
	public void create(Academy academy) {
		log.debug("academy created from academy: " + academy.toString());
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(academy);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

    
    /**
     * Updates the academy information as passed by the Academy object. 
     *     If the information is null or empty the field will not be updated
     *     
     * @param academy	Academy object to change. The academy_id must be the one that needs
     * 						to be changed and it must exist in the database
     */
	public void update(Academy academy){
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
    	
    	Academy academy2 = (Academy) entityManager.find(Academy.class, academy.getAcademy_id());
    	
    	if(!academy.getName().isEmpty() || !(academy == null))
    		academy2.setName( academy.getName() );
    	
    	if(!academy.getTax_id().isEmpty() || !(academy.getTax_id() == null))
    		academy2.setTax_id(academy.getTax_id());
    	
    	entityManager.getTransaction().commit();
    	entityManager.close();
    }
    
    
    /**
	 * Finds an Academy in the database using id, or name, or tax_id
	 * 
	 * @param Academy
	 * 
	 * @return list of academies
	 */
	public List<Academy> read(Academy a) {
		
		if (a == null){
			return null;
		}
		
		if (a.getAcademy_id() == null && a.getName() == null && a.getTax_id() == null ){
			return null;
		}
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
    
		if (a.getAcademy_id() != null) {
			Academy la = entityManager.find(Academy.class, a.getAcademy_id());
			entityManager.getTransaction().commit();
			entityManager.close();
			List<Academy> l = new ArrayList<Academy>();
			l.add(la);
			return l;
			
		} else {
			List<Academy> results = (List<Academy>) entityManager.find(Academy.class, a.getName());

			if (results == null || results.isEmpty()) {
				results = (List<Academy>) entityManager.find(Academy.class, a.getTax_id());
			}
			entityManager.getTransaction().commit();
			entityManager.close();
			if (results == null || results.isEmpty()) {
				return null;
			} else {
				return results;
			}
		}

    }
    
    
    /**
     * Deletes the academy passed by the client
     * 
     * @param academy to delete
     */
	public void delete(Academy academy){
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// em does not contain academy, maybe just merge then remove will work, but leaving this as it in case is needed later.
    	entityManager.remove(entityManager.contains(academy) ? academy : entityManager.merge(academy));
    	entityManager.getTransaction().commit();
    	entityManager.close();
    }
    
}
