package com.roundrocklabs.test.academy.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.roundrocklabs.academy.dao.IAcademyDAO;
import com.roundrocklabs.academy.dao.impl.AcademyDAOImpl;
import com.roundrocklabs.academy.model.Academy;
import com.roundrocklabs.test.academy.manager.AcademyManagerTest;
import com.roundrocklabs.test.academy.utils.Rand;

public class AcademyDAOImplTest {

	private static final Log log = LogFactory.getLog(AcademyManagerTest.class);

	@Test
	public void createAcademyAcademy() {
		log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		Academy a = new Academy();
		a.setName(Rand.getRandomName());
		a.setTax_id(Rand.getRandomTaxID());

		IAcademyDAO ad = new AcademyDAOImpl();
		Integer i = ad.create(a);
		assert(i!=null);
		log.info("academy created returned id " + i);
		log.info(a.toString());

		Academy a2 = ad.readByID(i);
		assert(a.equals(a2));
		log.info("read academy object: "+a2.toString());
	}


	@Test
	public void createAcademyStringString() {
		log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		Academy a = new Academy();
		a.setName(Rand.getRandomName());
		a.setTax_id(Rand.getRandomTaxID());
		IAcademyDAO ad = new AcademyDAOImpl();
		Integer i = ad.create(a.getName(),a.getTax_id());
		assert(i != null);
		a.setAcademy_id(i);
		log.info("academy created returned id " + i);
		log.info(a.toString());

		Academy a2 = ad.readByID(i);
		assert(a.equals(a2));
		log.info("read academy object: "+a2.toString());
	}


	@Test
	public void createAcademyString() {
		log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		Academy a = new Academy();
		a.setName(Rand.getRandomName());
		IAcademyDAO ad = new AcademyDAOImpl();
		Integer i = ad.create(a.getName());
		assert(i != null);
		a.setAcademy_id(i);
		log.info("academy created returned id " + i);
		log.info(a.toString());

		Academy a2 = ad.readByID(i);
		assert(a.equals(a2));
		log.info("read academy object: " + a2.toString());
	}


	@Test
	public void deleteAcademy() {
		log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		Academy a = new Academy();
		a.setName(Rand.getRandomName());
		IAcademyDAO ad = new AcademyDAOImpl();
		Integer i = ad.create(a.getName());
		assert(i != null);
		log.info("academy created returned id " + i);
		log.info(a.toString());
		a = ad.readByID(i);
		
		ad.delete(a);
		Academy a2 = ad.readByID(i);
		assert(a2 == null);
	}

	@Test
	public void getAcademiesByName() {
		log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		Academy a = new Academy();
		a.setName(Rand.getRandomName());
		IAcademyDAO ad = new AcademyDAOImpl();
		Integer i = ad.create(a.getName());
		assert(i != null);
		a.setAcademy_id(i);
		log.info("academy created returned id " + i);
		log.info(a.toString());

		List<Academy> a2 = (List<Academy>) ad.readByName(a.getName());
		for(Academy ac : a2){
			log.info("academy read: " + ac.toString());
			if(ac.equals(a)){
				log.info("read academy object: " + a2.toString());
				assert(true);
				return;
			}
		}
		assert(false);
	}

	@Test
	public void updateAcademy() {
		log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		Academy a = new Academy();
		a.setName(Rand.getRandomName());
		IAcademyDAO ad = new AcademyDAOImpl();
		Integer i = ad.create(a.getName());
		assert(i != null);
		a.setAcademy_id(i);
		log.info("academy created returned id " + i);
		log.info(a.toString());

		Academy a2 = ad.readByID(i);
		a2.setTax_id(Rand.getRandomTaxID());
		ad.update(a2);
		
		Academy a3 = ad.readByID(i);
		assert(a2.equals(a3));
		log.info("read academy object: " + a2.toString());
	}
	
	@BeforeMethod
	public void setup(){
		log.info("\n\n#########################################################################################");
	}
}
