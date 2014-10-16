package com.roundrocklabs.test.academy.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.junit.Test;

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
		a = ad.create(a);
		assert (a != null);
		log.info("academy created returned id " + a.getAcademy_id());
		log.info(a.toString());

		Academy a2 = (Academy) ad.read(a);
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
		a = ad.create(a);
		assert (a != null);
		log.info("academy created returned id " + a.toString());
		log.info(a.toString());

		Academy a2 = (Academy) ad.read(a);
		assert(a.equals(a2));
		log.info("read academy object: "+a2.toString());
	}


	@Test
	public void createAcademyString() {
		log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		Academy a = new Academy();
		a.setName(Rand.getRandomName());
		IAcademyDAO ad = new AcademyDAOImpl();
		a = ad.create(a);
		assert (a != null);

		log.info("academy created returned id " + a.getAcademy_id());
		log.info(a.toString());

		Academy a2 = (Academy) ad.read(a);
		assert(a.equals(a2));
		log.info("read academy object: " + a2.toString());
	}


	@Test
	public void deleteAcademy() {
		log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		Academy a = new Academy();
		a.setName(Rand.getRandomName());
		IAcademyDAO ad = new AcademyDAOImpl();
		a = ad.create(a);
		assert (a != null);
		log.info("academy created returned id " + a.getAcademy_id());
		log.info(a.toString());
		
		ad.delete(a);
		Academy a2 = (Academy) ad.read(a);
		assert(a2 == null);
	}

	@Test
	public void getAcademiesByName() {
		log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		Academy a = new Academy();
		a.setName(Rand.getRandomName());
		IAcademyDAO ad = new AcademyDAOImpl();
		a = ad.create(a);
		assert (a != null);

		log.info("academy created returned id " + a.getAcademy_id());
		log.info(a.toString());

		List<Academy> a2 = ad.read(a);
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
		a = ad.create(a);
		assert (a != null);

		log.info("academy created returned id " + a.getAcademy_id());
		log.info(a.toString());

		Academy a2 = (Academy) ad.read(a);
		a2.setTax_id(Rand.getRandomTaxID());
		ad.update(a2);
		
		Academy a3 = (Academy) ad.read(a);
		assert(a2.equals(a3));
		log.info("read academy object: " + a2.toString());
	}
	
	@Before
	public void setup(){
		log.info("\n\n#########################################################################################");
	}
}
