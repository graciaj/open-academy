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
	private static final Log LOG = LogFactory.getLog(AcademyDAOImpl.class);
	private static EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("oaPu");
	private static EntityManager entityManager;

	/**
	 * Saves the Academy object to the database
	 * 
	 * @param academy	Academy object to create
	 * 
	 */
    @Override
	public void create(Academy academy) {
		LOG.debug("academy created from academy: " + academy.toString());
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
    @Override
	public void update(Academy academy){
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
    	
    	Academy academy2 = (Academy) entityManager.find(Academy.class, academy.getAcademyId());
    	
    	if(!academy.getName().isEmpty() || !(academy == null))
    		academy2.setName( academy.getName() );
    	
    	if(!academy.getTaxId().isEmpty() || !(academy.getTaxId() == null))
    		academy2.setTaxId(academy.getTaxId());
    	
    	entityManager.getTransaction().commit();
    	entityManager.close();
    }
    
    
    /**
	 * Finds an Academy in the database using id, or name, or tax_id
	 * 
	 * @param academy
	 * 
	 * @return list of academies
	 */
    @Override
	public List<Academy> read(Academy academy) {
		ArrayList<Academy> l = new ArrayList<Academy>();

		if (academy == null){
			return l;
		}
		
		if (academy.getAcademyId() == null && academy.getName() == null && academy.getTaxId() == null ){
			return l;
		}
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
    
		if (academy.getAcademyId() != null) {
			Academy la = entityManager.find(Academy.class, academy.getAcademyId());
			entityManager.getTransaction().commit();
			entityManager.close();
			l = new ArrayList<Academy>();
			l.add(la);
			return l;
			
		} else {
			List<Academy> results = (List<Academy>) entityManager.find(Academy.class, academy.getName());

			if (results == null || results.isEmpty()) {
				results = (List<Academy>) entityManager.find(Academy.class, academy.getTaxId());
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
    @Override
	public void delete(Academy academy){
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// em does not contain academy, maybe just merge then remove will work, but leaving this as it in case is needed later.
    	entityManager.remove(entityManager.contains(academy) ? academy : entityManager.merge(academy));
    	entityManager.getTransaction().commit();
    	entityManager.close();
    }
    
}
