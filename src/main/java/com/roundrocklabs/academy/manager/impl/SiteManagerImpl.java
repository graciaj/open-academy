package com.roundrocklabs.academy.manager.impl;

import java.util.List;

import com.roundrocklabs.academy.dao.ISiteDAO;
import com.roundrocklabs.academy.dao.impl.SiteDAOImpl;
import com.roundrocklabs.academy.manager.ISiteManager;
import com.roundrocklabs.academy.model.Site;

public class SiteManagerImpl implements ISiteManager {

	private ISiteDAO siteDAO = new SiteDAOImpl();

    @Override
	public void create(Site site) {
		siteDAO.create(site);
	}

    @Override
	public List<Site> read(Site s) {
		return siteDAO.read(s);
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
