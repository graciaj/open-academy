package com.roundrocklabs.academy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.roundrocklabs.academy.dao.ISiteDAO;
import com.roundrocklabs.academy.model.Site;

public class SiteDAOImpl implements ISiteDAO {
	private static final Log LOG = LogFactory.getLog(SiteDAOImpl.class);
	private static EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("oaPu");
	private static EntityManager entityManager;

    @Override
	public void create(Site site) {
		LOG.debug("site created from: " + site.toString());
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(site);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

    @Override
	public List<Site> read(Site s) {
		LOG.debug("Reading a Site by id: " + s.toString());
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		if (s.getSiteId() != null) {
			Site s2 = entityManager.find(Site.class, s.getSiteId());
			entityManager.getTransaction().commit();
			entityManager.close();
			List<Site> ls = new ArrayList<Site>();
			ls.add(s2);
			return ls;
		} else {
			
			List<Site> results = (List<Site>) entityManager.find(Site.class, s.getName());

			if (results == null || results.isEmpty()) {
				results = (List<Site>) entityManager.find(Site.class, s.getDescription());
			}
			entityManager.getTransaction().commit();
			entityManager.close();
			if (results == null || results.isEmpty()) {
				return new ArrayList<Site>();
			} else {
				return results;
			}
		}

	}

    @Override
	public void update(Site site) {
		LOG.debug("updating site: " + site.toString());
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Site site2 = (Site) entityManager.find(Site.class, site.getSiteId());

		if (!(site == null) || !site.getName().isEmpty())
			site2.setName(site.getName());

		if (!(site.getDescription() == null) || !site.getDescription().isEmpty())
			site2.setDescription(site.getDescription());

		if (!(site.getAcademy() == null))
			site2.setAcademy(site.getAcademy());

		if (!(site.getAddress1() == null) || !(site.getAddress1().isEmpty()))
			site2.setAddress1(site.getAddress1());

		if (!(site.getAddress2() == null) || !(site.getAddress2().isEmpty()))
			site2.setAddress2(site.getAddress2());

		if (!(site.getCity() == null) || !(site.getCity().isEmpty()))
			site2.setCity(site.getCity());

		if (!(site.getState() == null) || !(site.getState().isEmpty()))
			site2.setState(site.getState());

		if (!(site.getZip() == null) || !(site.getZip().isEmpty()))
			site2.setZip(site.getZip());
		
		entityManager.getTransaction().commit();
		entityManager.close();

	}

    @Override
	public void delete(Site site) {
		LOG.debug("Deleting site: " + site.toString());
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(site);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
