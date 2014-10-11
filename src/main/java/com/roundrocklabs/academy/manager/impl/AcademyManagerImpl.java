package com.roundrocklabs.academy.manager.impl;

import java.util.List;

import com.roundrocklabs.academy.dao.IAcademyDAO;
import com.roundrocklabs.academy.dao.impl.AcademyDAOImpl;
import com.roundrocklabs.academy.manager.IAcademyManager;
import com.roundrocklabs.academy.model.Academy;


public class AcademyManagerImpl implements IAcademyManager{
	
	private IAcademyDAO academyDAO = new AcademyDAOImpl();
	
	@Override
	public Integer create(String name, String tax_id) {
		return academyDAO.create(name, tax_id);
	}

	@Override
	public Integer create(String name) {
		return academyDAO.create(name);
	}
	
	@Override
	public Integer create(Academy academy){
		return academyDAO.create(academy);
	}
	
	@Override
	public void update(Academy academy){
		academyDAO.update(academy);
	}
	
	@Override
	public Academy readByID(Integer id){
		return academyDAO.readByID(id);
	}
	
	@Override
	public List<Academy> readByName(String str){
		return academyDAO.readByName(str);
	}
	
	@Override
	public void delete(Academy academy){
		academyDAO.delete(academy);
	}
	
}
