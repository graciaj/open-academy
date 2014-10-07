package com.roundrocklabs.test.academy.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import com.roundrocklabs.academy.dao.IAcademyDAO;
import com.roundrocklabs.academy.dao.impl.AcademyDAOImpl;
import com.roundrocklabs.academy.model.Academy;
import com.roundrocklabs.test.academy.manager.AcademyManagerTest;

public class AcademyDAOImplTest {
	private static final Log log = LogFactory.getLog(AcademyManagerTest.class);
	
  @Test
  public void createAcademyAcademy() {
    Academy a = new Academy("name","tax");
    IAcademyDAO ad = new AcademyDAOImpl();
    Integer i = ad.createAcademy(a);
    log.info("academy created returned id " + i);
    log.info(a.toString());
    
    
  }

  @Test
  public void createAcademyStringString() {
	    Academy a = new Academy("name","tax");
	    IAcademyDAO ad = new AcademyDAOImpl();
	    Integer i = ad.createAcademy(a);
	    log.info("academy created returned id " + i);
	    log.info(a.toString());
  }

  @Test
  public void createAcademyString() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void deleteAcademy() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getAcademiesByName() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getAcademyByID() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void updateAcademy() {
    throw new RuntimeException("Test not implemented");
  }
}
