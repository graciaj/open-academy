package com.roundrocklabs.academy.bean;

import org.hibernate.collection.internal.PersistentSet;

public class Academy {
	private Integer academy_id;
	private String name;
	private String tax_id;
	private PersistentSet sites;

	public Academy() {}
	
	public Academy(String name, String tax_id) {
		this.setName(name);
		this.setTax_id(tax_id);
	}
	
	public Integer getAcademy_id() {
		return academy_id;
	}
	public void setAcademy_id(Integer academy_id) {
		this.academy_id = academy_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTax_id() {
		return tax_id;
	}
	public void setTax_id(String tax_id) {
		this.tax_id = tax_id;
	}
	
	
	public PersistentSet getSites() {
		return sites;
	}

	public void setSites(PersistentSet sites) {
		this.sites = sites;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Academy guest = (Academy) obj;
        return (this.academy_id == guest.academy_id || (this.academy_id.equals(guest.academy_id)))
        		&& (this.name == guest.name  || (this.name != null && this.name.equals(guest.getName())))
                && (this.tax_id == guest.tax_id || (this.tax_id != null && this.tax_id.equals(guest.getTax_id())));
    }
   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((name == null) ? 0 : name.hashCode());
        result = prime * result + academy_id;
        result = prime * result
                + ((tax_id == null) ? 0 : tax_id.hashCode());
        return result;
    }

    @Override
    public String toString(){
    	return "Academy_id: "+ String.valueOf(this.academy_id) + 
    			", name: " + this.name + ", tax_id: " + this.tax_id;
    }
	
}
