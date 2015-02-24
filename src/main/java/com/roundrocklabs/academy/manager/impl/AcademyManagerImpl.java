package com.roundrocklabs.academy.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.roundrocklabs.academy.dao.IAcademyDAO;
import com.roundrocklabs.academy.dao.impl.AcademyDAOImpl;
import com.roundrocklabs.academy.manager.IAcademyManager;
import com.roundrocklabs.academy.model.Academy;


public class AcademyManagerImpl implements IAcademyManager {
	
	@Autowired
	private IAcademyDAO academyDAO;
	
	public void create(Academy a) {
		academyDAO.create(a);
	}
	
	public void update(Academy a) {
		academyDAO.update(a);
	}

	public List<Academy> read(Academy a) {
		return academyDAO.read(a);
	}
	
	public void delete(Academy academy){
		academyDAO.delete(academy);
	}
	
}
