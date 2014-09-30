package com.roundrocklabs.test.academy.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.roundrocklabs.academy.bean.*;
import com.roundrocklabs.academy.manager.AcademyManager;

public class AcademyManagerTest {
	private static final Log log = LogFactory.getLog(AcademyManagerTest.class);
	 
	@BeforeMethod
	public void setup(){
		log.info("\n\nBeginning Method --------------------------------------------------->>");
	}
	
	@Test(groups = { "regression" })
	public void createAcademyByNameTax() {
		AcademyManager am = new AcademyManager();
		Academy academy = new Academy("createAcademyByNameTax-name","createAcademyByNameTax-tax");
		
		Integer id = am.createAcademy(academy);
		Academy savedAcademy = am.getAcademyByID(id);
		assert(academy.equals(savedAcademy));
		log.debug("createAcademyByNameTax : " + savedAcademy.toString());
	}

	@Test(groups = { "regression" })
	public void createAcademyByName() {
		AcademyManager am = new AcademyManager();
		Academy academy = new Academy();
		academy.setName("createAcademyByNameTax-name");
		
		Integer id = am.createAcademy(academy);
		Academy savedAcademy = am.getAcademyByID(id);
		assert(academy.equals(savedAcademy));
		log.debug("createAcademyByName : " + savedAcademy.toString());
	}

	
	@Test(groups = { "regression" })
	public Academy createAcademyByAcademyNoID(){
		AcademyManager am = new AcademyManager();
		Academy academy = new Academy();
		academy.setName("createAcademyByAcademyNoID-name");
		academy.setTax_id("createAcademyByAcademyNoID-tax");
		
		academy.setAcademy_id(am.createAcademy(academy));
		Academy savedAcademy = am.getAcademyByID(academy.getAcademy_id());
		assert(academy.equals(savedAcademy));
		log.debug("createAcademyByName : " + savedAcademy.toString());
		return savedAcademy;
	}
	
	
	@Test(groups = { "regression" })
	public void updateAcademy() {
		AcademyManager am = new AcademyManager();
		Academy academy = new Academy();
		
		academy.setAcademy_id(new Integer(28));
		academy.setName("updated_by_testng");
		academy.setTax_id("testng");
		am.updateAcademy(academy);
		
		Academy savedAcademy = am.getAcademyByID(new Integer(28));
		assert(academy.equals(savedAcademy));
		
		log.debug("updateAcademy : original : " + academy.toString());
		log.debug("updateAcademy : saved : " + savedAcademy.toString());

	}
  
	@Test(groups = { "regression" })
	public void getAcademyByID(){
		AcademyManager am = new AcademyManager();
		
		Academy academy = (Academy) am.getAcademyByID(24);
		assert(academy != null);
		log.debug("getAcademyByID : " + academy.toString());
	}

	
	@Test(groups = { "regression" })
	public void getAcademyByName(){
		AcademyManager am = new AcademyManager();
		
		List<Academy> list = new ArrayList<Academy>();
		list = (List<Academy>) am.getAcademyByName("academy1");
		assert(list != null);
		assert(list.size() > 0);
		for(Academy academy : list){
			log.debug("getAcademyByName : " + academy.toString());
		}
	}
	
	
	@Test(groups = { "regression" })
	public void getAcademyByTaxID(){
		AcademyManager am = new AcademyManager();
		
		List<Academy> list = new ArrayList<Academy>();
		list = (List<Academy>) am.getAcademyByName("tax_changed");
		assert(list != null);
		assert(list.size() > 0);
		for(Academy academy : list){
			log.debug("getAcademyByTaxID : " + academy.toString());
		}
	}
	
}
