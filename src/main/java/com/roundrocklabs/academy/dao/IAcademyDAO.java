package com.roundrocklabs.academy.dao;

import java.util.List;

import com.roundrocklabs.academy.model.Academy;

public interface IAcademyDAO {

	public void create(Academy a);
	
	public void update(Academy a);
	
	public List<Academy> read(Academy a);
	
	public void delete(Academy a);
	
}
