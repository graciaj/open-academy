package com.roundrocklabs.test.academy.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.roundrocklabs.academy.manager.IAcademyManager;
import com.roundrocklabs.academy.manager.impl.AcademyManagerImpl;
import com.roundrocklabs.academy.model.*;
import com.roundrocklabs.test.academy.utils.RandomUtil;


public class AcademyManagerTest  {
	private static final Log log = LogFactory.getLog(AcademyManagerTest.class);
	
	@BeforeMethod
	public void setup(){
		log.info("\n\nBeginning Method --------------------------------------------------->>");
	}
	
	@Test(groups = { "regression" })
	public void createAcademyByNameTax() {
		
		IAcademyManager am = new AcademyManagerImpl();
		String name = RandomUtil.getRandomName();
		String tax = RandomUtil.getRandomTaxID();
		Academy academy = new Academy();
		academy.setName(name);
		academy.setTax_id(tax);
		
		am.createAcademy(name,tax);
		
		List<Academy> savedAcademy = (List<Academy>) am.readAcademiesByName(name);
		log.debug("createAcademyByNameTax : " + savedAcademy.toString());
		
		for(Academy ac : savedAcademy){
			if(ac.getName().equals(academy.getName()) || ac.getTax_id().equals(academy.getTax_id())){
				assert(true);
				return;
			}
		}
		assert(false);
	}

	
	@Test(groups = { "regression" })
	public void createAcademyByName() {
		IAcademyManager am = new AcademyManagerImpl();
		String name = RandomUtil.getRandomName();
		Academy academy = new Academy();
		academy.setName(name);
		
		am.createAcademy(name);
		
		List<Academy> savedAcademy = (List<Academy>) am.readAcademiesByName(name);
		log.debug("createAcademyByName : " + savedAcademy.toString());
		for(Academy ac : savedAcademy){
			if(ac.getName().equals(academy.getName()) || ac.getTax_id().equals(academy.getTax_id())){
				assert(true);
				return;
			}
		}
		assert(false);
	}
	
	
	@Test(groups = { "regression" })
	public void updateAcademy() {
		IAcademyManager am = new AcademyManagerImpl();
		Academy academy = new Academy();
		
		academy.setAcademy_id(new Integer(28));
		academy.setName("updated_by_testng");
		academy.setTax_id("testng");
		am.updateAcademy(academy);
		
		Academy savedAcademy = am.readAcademyByID(new Integer(28));
		assert(academy.equals(savedAcademy));
		
		log.debug("updateAcademy : original : " + academy.toString());
		log.debug("updateAcademy : saved : " + savedAcademy.toString());

	}
  
	@Test(groups = { "regression" })
	public void readAcademyByID(){
		IAcademyManager am = new AcademyManagerImpl();
		Academy academy = (Academy) am.readAcademyByID(24);
		assert(academy != null);
		log.debug("getAcademyByID : " + academy.toString());
	}

	
	@Test(groups = { "regression" })
	public void readAcademyByName(){
		IAcademyManager am = new AcademyManagerImpl();
		List<Academy> list = new ArrayList<Academy>();
		list = (List<Academy>) am.readAcademiesByName("academy1");
		assert(list != null);
		assert(list.size() > 0);
		for(Academy academy : list){
			log.debug("getAcademyByName : " + academy.toString());
		}
	}
	
	
	@Test(groups = { "regression" })
	public void readAcademyByTaxID(){
		IAcademyManager am = new AcademyManagerImpl();
		List<Academy> list = new ArrayList<Academy>();
		list = (List<Academy>) am.readAcademiesByName("tax_changed");
		assert(list != null);
		assert(list.size() > 0);
		for(Academy academy : list){
			log.debug("getAcademyByTaxID : " + academy.toString());
		}
	}
	
	
	@Test(groups = {"functional", "regression"})
	public void deleteAcademy(){
		IAcademyManager am = new AcademyManagerImpl();
		String name = RandomUtil.getRandomName();
		String tax = RandomUtil.getRandomTaxID();
		
		Academy academy = new Academy();
		academy.setName(name);
		academy.setTax_id(tax);
		Integer id = (Integer) am.createAcademy(academy);
		
		log.debug(academy.toString());
		
		Academy savedAcademy = am.readAcademyByID(academy.getAcademy_id());
		assert(academy.equals(savedAcademy));
		
		log.debug("deleteAcademy : " + savedAcademy.toString());
		
		am.deleteAcademy(savedAcademy);
		Academy deletedAcademy = am.readAcademyByID(savedAcademy.getAcademy_id());
		assert(deletedAcademy == null);
		
	}
}
