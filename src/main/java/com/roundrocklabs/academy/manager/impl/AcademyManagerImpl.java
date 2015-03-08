package com.roundrocklabs.academy.manager.impl;

import java.util.List;

import com.roundrocklabs.academy.dao.IAcademyDAO;
import com.roundrocklabs.academy.dao.impl.AcademyDAOImpl;
import com.roundrocklabs.academy.manager.IAcademyManager;
import com.roundrocklabs.academy.model.Academy;

public class AcademyManagerImpl implements IAcademyManager {

    private IAcademyDAO academyDAO = new AcademyDAOImpl();

    @Override
    public void create(Academy a) {
        academyDAO.create(a);
    }

    @Override
    public void update(Academy a) {
        academyDAO.update(a);
    }

    @Override
    public List<Academy> read(Academy a) {
        return academyDAO.read(a);
    }

    @Override
    public void delete(Academy academy){
        academyDAO.delete(academy);
    }

}
