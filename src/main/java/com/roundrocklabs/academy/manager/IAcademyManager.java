package com.roundrocklabs.academy.manager;

import java.util.List;

import com.roundrocklabs.academy.model.Academy;

public interface IAcademyManager {
	
	public Integer create(Academy academy);
	
	public Integer create(String name, String tax_id);
	
	public Integer create(String name);
	
	public void update(Academy academy);
	
	public Academy readByID(Integer id);
	
	public List<Academy> readByName(String str);
	
	public void delete(Academy academy);
	
}
