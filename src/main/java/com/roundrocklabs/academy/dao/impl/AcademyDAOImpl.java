/**
 * @author Lehi Gracia
 * @copyright 2014 Lehi Gracia
 */


package com.roundrocklabs.academy.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import com.roundrocklabs.academy.dao.IAcademyDAO;
import com.roundrocklabs.academy.model.Academy;
import com.roundrocklabs.academy.utils.HibernateUtil;


public class AcademyDAOImpl implements IAcademyDAO {
	private static final Log log = LogFactory.getLog(AcademyDAOImpl.class);
	
	
	/**
	 * Saves the Academy object to the database
	 * 
	 * @param academy	Academy object to create
	 * @return 	Academy id as stored in the database
	 */
	public Integer create(Academy academy){
		log.debug("academy created from academy: " + academy.toString());

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(academy);
		session.getTransaction().commit();
		return id;	
	}
	
	/**
	 * Creates a new Academy object and saves it to the database
	 * @param name		Name of the academy
	 * @param tax_id	Tax id of the academy if included
	 * @return			Academy id as stored in the database
	 */
    public Integer create(String name, String tax_id) {
    	log.debug("academy called from name: "+ name + " and tax_id: " + tax_id); 
    	
    	Academy academy = new Academy();
        academy.setName(name);   
        academy.setTax_id(tax_id);
        
        Integer id = (Integer) create(academy);
        return id;
    }
    
    
    /**
     * Creates a new Academy object and saves it to the database. Tax id will be null
     * 
     * @param name	Name of the academy
     * @return		Academy id as stored in the databse
     */
    public Integer create(String name){
    	log.debug("academy called from name: "+ name); 
    	Integer id = (Integer) create(name, null);
    	return id;
    }
    
    
    /**
     * Updates the academy information as passed by the Academy object. 
     *     If the information is null or empty the field will not be updated
     *     
     * @param academy	Academy object to change. The academy_id must be the one that needs
     * 						to be changed and it must exist in the database
     */
    public void update(Academy academy){
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	
    	Academy academy2 = (Academy) session.load(Academy.class, academy.getAcademy_id());
    	
    	if(!academy.getName().isEmpty() || !(academy == null))
    		academy2.setName( academy.getName() );
    	
    	if(!academy.getTax_id().isEmpty() || !(academy.getTax_id() == null))
    		academy2.setTax_id(academy.getTax_id());
    	
    	session.getTransaction().commit();
    }
    
    
    /**
     * Finds an Academy in the database
     * 
     * @param id
     * @return
     */
    public Academy readByID(Integer id){
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    
    	Query query = session.createQuery("from Academy a where a.academy_id = :id")
    			.setParameter("id", id);
    	
    	Academy academy = (Academy) query.uniqueResult();
    	session.getTransaction().commit();
    	
    	return academy;
    }
    
    
    /**
     * Finds an Academy by a partial name or partial tax id
     * 
     * @param str
     * @return the list of Academies or null if not found
     */
    @SuppressWarnings("unchecked")
	public List<Academy> readByName(String str){
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from Academy a where str(a.name) like :name")
    			.setParameter("name", str);
    	
    	List<Academy> results = query.list();
    	
    	if(results == null || results.isEmpty()){
    		Query query2 =session.createQuery("from Academy a where str(a.tax_id) like :tax_id")
        			.setParameter("tax_id", str);
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
     * Deletes the academy passed by the client
     * 
     * @param academy to delete
     */
    public void delete(Academy academy){
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	
    	Academy db_academy = (Academy) session.load(Academy.class, academy.getAcademy_id());
    	session.delete(db_academy);
    	
    	session.getTransaction().commit();
    }
    
}
