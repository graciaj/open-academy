package com.roundrocklabs.test.academy.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.roundrocklabs.academy.manager.AcademyManager;
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
		
		AcademyManager am = new AcademyManagerImpl();
		String name = RandomUtil.getRandomName();
		String tax = RandomUtil.getRandomTaxID();
		Academy academy = new Academy();
		academy.setName(name);
		academy.setTax_id(tax);
		
		am.createAcademy(name,tax);
		
		List<Academy> savedAcademy = (List<Academy>) am.getAcademiesByName(name);
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
		AcademyManager am = new AcademyManagerImpl();
		String name = RandomUtil.getRandomName();
		Academy academy = new Academy();
		academy.setName(name);
		
		am.createAcademy(name);
		
		List<Academy> savedAcademy = (List<Academy>) am.getAcademiesByName(name);
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
		AcademyManager am = new AcademyManagerImpl();
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
		AcademyManager am = new AcademyManagerImpl();
		Academy academy = (Academy) am.getAcademyByID(24);
		assert(academy != null);
		log.debug("getAcademyByID : " + academy.toString());
	}

	
	@Test(groups = { "regression" })
	public void getAcademyByName(){
		AcademyManager am = new AcademyManagerImpl();
		List<Academy> list = new ArrayList<Academy>();
		list = (List<Academy>) am.getAcademiesByName("academy1");
		assert(list != null);
		assert(list.size() > 0);
		for(Academy academy : list){
			log.debug("getAcademyByName : " + academy.toString());
		}
	}
	
	
	@Test(groups = { "regression" })
	public void getAcademyByTaxID(){
		AcademyManager am = new AcademyManagerImpl();
		List<Academy> list = new ArrayList<Academy>();
		list = (List<Academy>) am.getAcademiesByName("tax_changed");
		assert(list != null);
		assert(list.size() > 0);
		for(Academy academy : list){
			log.debug("getAcademyByTaxID : " + academy.toString());
		}
	}
	
	
//	@Test(groups = {"functional", "regression"})
//	public void deleteAcademy(){
//		AcademyManager am = new AcademyManagerImpl();
//		String name = RandomUtil.getRandomName();
//		String tax = RandomUtil.getRandomTaxID();
//		
//		Academy academy = new Academy();
//		academy.setName(name);
//		academy.setTax_id(tax);
//		am.createAcademy(academy);
//		
//		academy.setAcademy_id(am.getAcademiesByName(name));
//		Academy savedAcademy = am.getAcademyByID(academy.getAcademy_id());
//		assert(academy.equals(savedAcademy));
//		
//		log.debug("deleteAcademy : " + savedAcademy.toString());
//		
//		am.deleteAcademy(savedAcademy);
//		Academy deletedAcademy = am.getAcademyByID(savedAcademy.getAcademy_id());
//		assert(deletedAcademy == null);
//		
//	}
}
