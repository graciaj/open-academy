package com.roundrocklabs.academy.dao;

import java.util.List;

import com.roundrocklabs.academy.model.Site;

public interface ISiteDAO {

	public Site create(Site a);
	
	public void update(Site a);
	
	public List<Site> read(Site a);
	
	public void delete(Site a);
	
}
