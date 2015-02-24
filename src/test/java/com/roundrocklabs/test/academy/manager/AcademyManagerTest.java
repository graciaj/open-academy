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
		log.info("\n\nAcademyManagerTest Beginning Method --------------------------------------------------->>");
	}
	
	@Test(groups = { "regression" })
	public void createAcademyByNameTax() {
		String name = Rand.getRandomName();
		String tax = Rand.getRandomTaxID();
		Academy academy = new Academy(name, tax);
		IAcademyManager am = new AcademyManagerImpl();
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
		String name = Rand.getRandomName();
		Academy academy = new Academy(name);
		IAcademyManager am = new AcademyManagerImpl();
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
		Academy academy = new Academy();
		IAcademyManager am = new AcademyManagerImpl();		
		academy.setName("updated_by_testng");
		academy.setTax_id("testng");
		am.create(academy);

		List<Academy> savedAcademy = am.read(academy);
		assert(academy.equals(savedAcademy.get(0)));
		
		savedAcademy.get(0).setName("second update");
		savedAcademy.get(0).setTax_id("second testng");
		
		List<Academy> secondList = am.read(savedAcademy.get(0));
		
		log.debug("updateAcademy : original : " + academy.toString());
		log.debug("updateAcademy: saved: " + savedAcademy.get(0).toString());
		log.debug("updateAcademy : second : " + secondList.get(0).toString());

	}
	
	
	@Test(groups = { "regression" })
	public void readAcademyByName(){
		List<Academy> list = new ArrayList<Academy>();
		IAcademyManager am = new AcademyManagerImpl();
		Academy a = new Academy("academy1");
		am.create(a);
		list = am.read(a);
		assert(list != null);
		assert(list.size() > 0);
		for(Academy academy : list){
			log.debug("getAcademyByName : " + academy.toString());
		}
	}
	
	
	@Test(groups = { "regression" })
	public void readAcademyByTaxID(){
		List<Academy> list = new ArrayList<Academy>();
		IAcademyManager am = new AcademyManagerImpl();
		Academy a = new Academy(null, "tax_changed");
		am.create(a);
		list = am.read(a);
		assert(list != null);
		assert(list.size() > 0);
		for(Academy academy : list){
			log.debug("getAcademyByTaxID : " + academy.toString());
		}
	}
	
	
	@Test(groups = {"functional", "regression"})
	public void deleteAcademy(){
		String name = Rand.getRandomName();
		String tax = Rand.getRandomTaxID();
		IAcademyManager am = new AcademyManagerImpl();
		Academy academy = new Academy(name);
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
