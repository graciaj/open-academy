package com.roundrocklabs.academy.dao;

import java.util.List;

import com.roundrocklabs.academy.model.Academy;

public interface IAcademyDAO {

	public Integer createAcademy(Academy academy);
	
	public Integer createAcademy(String name, String tax_id);
	
	public Integer createAcademy(String name);
	
	public void updateAcademy(Academy academy);
	
	public Academy readAcademyByID(Integer id);
	
	public List<Academy> readAcademiesByName(String str);
	
	public void deleteAcademy(Academy academy);
	
}
