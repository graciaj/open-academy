package com.roundrocklabs.academy.dao;

import java.util.List;

import com.roundrocklabs.academy.model.Site;

public interface ISiteDAO {

	public Integer create(Site site);

	public Integer create(String name);

	public Site readById(Integer id);

	public List<Site> readByName(String name);

	public void update(Site site);

	public void delete(Site site);

}
