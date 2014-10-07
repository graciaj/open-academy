package com.roundrocklabs.academy.manager.impl;

import java.util.List;

import com.roundrocklabs.academy.dao.IAcademyDAO;
import com.roundrocklabs.academy.dao.impl.AcademyDAOImpl;
import com.roundrocklabs.academy.manager.IAcademyManager;
import com.roundrocklabs.academy.model.Academy;


public class AcademyManagerImpl implements IAcademyManager{
	
	private IAcademyDAO academyDAO = new AcademyDAOImpl();
	
	public Integer createAcademy(String name, String tax_id) {
		return (Integer) academyDAO.createAcademy(name, tax_id);
	}

	public Integer createAcademy(String name) {
		return (Integer) academyDAO.createAcademy(name);
	}
	
	public Integer createAcademy(Academy academy){
		return (Integer) academyDAO.createAcademy(academy);
	}
	
	public void updateAcademy(Academy academy){
		academyDAO.updateAcademy(academy);
	}
	
	public Academy readAcademyByID(Integer id){
		return (Academy) academyDAO.readAcademyByID(id);
	}
	
	public List<Academy> readAcademiesByName(String str){
		return (List<Academy>) academyDAO.readAcademiesByName(str);
	}
	
	public void deleteAcademy(Academy academy){
		academyDAO.deleteAcademy(academy);
	}
	
}
