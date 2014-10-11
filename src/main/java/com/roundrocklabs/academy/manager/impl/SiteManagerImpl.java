package com.roundrocklabs.academy.manager.impl;

import java.util.List;

import com.roundrocklabs.academy.dao.ISiteDAO;
import com.roundrocklabs.academy.dao.impl.SiteDAOImpl;
import com.roundrocklabs.academy.manager.ISiteManager;
import com.roundrocklabs.academy.model.Site;

public class SiteManagerImpl implements ISiteManager {
	ISiteDAO siteDAO = new SiteDAOImpl();
	@Override
	public Integer create(Site site) {
		return siteDAO.create(site);
	}

	@Override
	public Integer create(String name) {
		return siteDAO.create(name);
	}

	@Override
	public Site readById(Integer id) {
		return siteDAO.readById(id);
	}

	@Override
	public List<Site> readByName(String name) {
		return siteDAO.readByName(name);
	}

	@Override
	public void update(Site site) {
		siteDAO.update(site);
	}

	@Override
	public void delete(Site site) {
		siteDAO.delete(site);
	}

}
