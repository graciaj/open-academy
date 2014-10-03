package com.roundrocklabs.academy.manager;

import java.util.List;

import com.roundrocklabs.academy.model.Academy;

public interface AcademyManager {
	
	public void createAcademy(Academy academy);
	
	public void createAcademy(String name, String tax_id);
	
	public void createAcademy(String name);
	
	public void updateAcademy(Academy academy);
	
	public Academy getAcademyByID(Integer id);
	
	public List<Academy> getAcademiesByName(String str);
	
	public void deleteAcademy(Academy academy);
	
}
