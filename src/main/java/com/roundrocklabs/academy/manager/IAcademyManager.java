package com.roundrocklabs.academy.manager;

import java.util.List;

import com.roundrocklabs.academy.model.Academy;

public interface IAcademyManager {
	
	public Academy create(Academy a);

	public void update(Academy a);
	
	public List<Academy> read(Academy a);
	
	public void delete(Academy a);
	
}
