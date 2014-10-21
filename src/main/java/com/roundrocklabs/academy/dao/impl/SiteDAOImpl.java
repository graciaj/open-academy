package com.roundrocklabs.academy.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.roundrocklabs.academy.dao.ISiteDAO;
import com.roundrocklabs.academy.model.Site;
import com.roundrocklabs.academy.utils.HibernateUtil;

public class SiteDAOImpl implements ISiteDAO {
	private static final Log log = LogFactory.getLog(SiteDAOImpl.class);

	public Site create(Site site) {
		log.debug("site created from: " + site.toString());

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(site);
		session.getTransaction().commit();
		site.setSite_id(id);
		return site;
	}

	public List<Site> read(Site s) {
		log.debug("Reading a Site by id: " + s.toString());

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		if (s.getSite_id() != null) {
			Query query = session.createQuery("from Site s where s.site_id = :id").setParameter("id", s.getSite_id());

			List<Site> sites = query.list();
			session.getTransaction().commit();
			return sites;
		} else {
			Query query = session.createQuery("from Site s where str(s.name) like :name").setParameter("name",
					s.getName());

			List<Site> results = query.list();

			if (results == null || results.isEmpty()) {
				Query query2 = session.createQuery("from Site s where str(s.description) like :description")
						.setParameter("description", s.getDescription());
				results = query2.list();
			}

			session.getTransaction().commit();

			if (results == null || results.isEmpty()) {
				return null;
			} else {
				return results;
			}
		}

	}


	public void update(Site site) {
		log.debug("updating site: " + site.toString());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Site site2 = (Site) session.load(Site.class, site.getSite_id());

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

		session.getTransaction().commit();

	}

	public void delete(Site site) {
		log.debug("Deleting site: " + site.toString());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Site db_site = (Site) session.load(Site.class, site.getSite_id());
		session.delete(db_site);

		session.getTransaction().commit();
	}

}
