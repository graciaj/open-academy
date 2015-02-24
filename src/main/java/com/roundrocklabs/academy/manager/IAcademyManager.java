package com.roundrocklabs.academy.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.roundrocklabs.academy.dao.IAcademyDAO;
import com.roundrocklabs.academy.model.Academy;

public interface IAcademyManager {
	
	public void create(Academy a);

	public void update(Academy a);
	
	public List<Academy> read(Academy a);
	
	public void delete(Academy a);
	
}
