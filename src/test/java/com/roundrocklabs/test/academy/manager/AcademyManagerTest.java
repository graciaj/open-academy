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
import com.roundrocklabs.test.academy.utils.Rand;


public class AcademyManagerTest  {
	private static final Log log = LogFactory.getLog(AcademyManagerTest.class);
	
	@BeforeMethod
	public void setup(){
		log.info("\n\nBeginning Method --------------------------------------------------->>");
	}
	
	@Test(groups = { "regression" })
	public void createAcademyByNameTax() {
		
		IAcademyManager am = new AcademyManagerImpl();
		String name = Rand.getRandomName();
		String tax = Rand.getRandomTaxID();
		Academy academy = new Academy();
		academy.setName(name);
		academy.setTax_id(tax);
		
		am.create(name,tax);
		
		List<Academy> savedAcademy = (List<Academy>) am.readByName(name);
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
		String name = Rand.getRandomName();
		Academy academy = new Academy();
		academy.setName(name);
		
		am.create(name);
		
		List<Academy> savedAcademy = (List<Academy>) am.readByName(name);
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
		am.update(academy);
		
		Academy savedAcademy = am.readByID(new Integer(28));
		assert(academy.equals(savedAcademy));
		
		log.debug("updateAcademy : original : " + academy.toString());
		log.debug("updateAcademy : saved : " + savedAcademy.toString());

	}
  
	@Test(groups = { "regression" })
	public void readAcademyByID(){
		IAcademyManager am = new AcademyManagerImpl();
		Academy academy = (Academy) am.readByID(24);
		assert(academy != null);
		log.debug("getAcademyByID : " + academy.toString());
	}

	
	@Test(groups = { "regression" })
	public void readAcademyByName(){
		IAcademyManager am = new AcademyManagerImpl();
		List<Academy> list = new ArrayList<Academy>();
		list = (List<Academy>) am.readByName("academy1");
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
		list = (List<Academy>) am.readByName("tax_changed");
		assert(list != null);
		assert(list.size() > 0);
		for(Academy academy : list){
			log.debug("getAcademyByTaxID : " + academy.toString());
		}
	}
	
	
	@Test(groups = {"functional", "regression"})
	public void deleteAcademy(){
		IAcademyManager am = new AcademyManagerImpl();
		String name = Rand.getRandomName();
		String tax = Rand.getRandomTaxID();
		
		Academy academy = new Academy();
		academy.setName(name);
		academy.setTax_id(tax);
		Integer id = (Integer) am.create(academy);
		
		log.debug(academy.toString());
		
		Academy savedAcademy = am.readByID(academy.getAcademy_id());
		assert(academy.equals(savedAcademy));
		
		log.debug("deleteAcademy : " + savedAcademy.toString());
		
		am.delete(savedAcademy);
		Academy deletedAcademy = am.readByID(savedAcademy.getAcademy_id());
		assert(deletedAcademy == null);
		
	}
}
