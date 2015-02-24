package com.roundrocklabs.test.academy.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.roundrocklabs.academy.manager.IAcademyManager;
import com.roundrocklabs.academy.manager.impl.AcademyManagerImpl;
import com.roundrocklabs.academy.model.Academy;
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
		Academy academy = new Academy(name, tax);
		
		am.create(academy);
		
		List<Academy> savedAcademy = am.read(academy);
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
		Academy academy = new Academy(name);
		
		am.create(academy);
		
		List<Academy> savedAcademy = am.read(academy);
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
		
		academy.setAcademy_id("28");
		academy.setName("updated_by_testng");
		academy.setTax_id("testng");
		am.update(academy);
		
		List<Academy> savedAcademy = am.read(academy);
		assert(academy.equals(savedAcademy.get(0)));
		
		log.debug("updateAcademy : original : " + academy.toString());
		log.debug("updateAcademy : saved : " + savedAcademy.toString());

	}
  
	@Test(groups = { "regression" })
	public void readAcademyByID(){
		IAcademyManager am = new AcademyManagerImpl();
		Academy a = new Academy();
		a.setAcademy_id("24");
		List<Academy> academies = am.read(a);
		assert(academies != null);
		log.debug("getAcademyByID : " + academies.get(0).toString());
	}

	
	@Test(groups = { "regression" })
	public void readAcademyByName(){
		IAcademyManager am = new AcademyManagerImpl();
		List<Academy> list = new ArrayList<Academy>();
		list = am.read(new Academy("academy1"));
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
		list = am.read(new Academy(null, "tax_changed"));
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
		am.create(academy);
		
		log.debug(academy.toString());
		
		List<Academy> savedAcademy = am.read(academy);
		Academy aRead = new Academy();
		boolean found = false;
		for (Academy a : savedAcademy) {
			if (a.equals(academy)) {
				assert true : "academy found on list";
				aRead = a;
				found = true;
				break;
			}
		}
		if (!found)
			assert false : "academy expected but not found";
		
		log.debug("deleteAcademy : " + savedAcademy.toString());
		
		am.delete(aRead);
		assert(am.read(aRead).get(0) == null);
		
	}
}
