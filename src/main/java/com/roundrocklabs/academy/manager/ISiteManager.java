package com.roundrocklabs.academy.manager;

import java.util.List;

import com.roundrocklabs.academy.model.Site;

public interface ISiteManager {

    public void create(Site a);

    public void update(Site a);

    public List<Site> read(Site a);

    public void delete(Site a);

}
