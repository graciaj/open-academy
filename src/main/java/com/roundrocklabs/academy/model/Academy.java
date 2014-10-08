/**
 * @author Lehi Gracia
 * @copyright 2014 Lehi Gracia
 */

package com.roundrocklabs.academy.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "academy")
public class Academy {
	
	
	private Integer academy_id;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable = false, unique = true)
	public Integer getAcademy_id() {
		return academy_id;
	}
	public void setAcademy_id(Integer academy_id) {
		this.academy_id = academy_id;
	}


	public Academy() {}
		
	public Academy(String name, String tax_id) {
		this.setName(name);
		this.setTax_id(tax_id);
	}
	
	
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	String tax_id;
	public String getTax_id() {
		return tax_id;
	}
	public void setTax_id(String tax_id) {
		this.tax_id = tax_id;
	}
	

	private List<Site> sites;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academy")
	public List<Site> getSites() {
		return sites;
	}
	public void setSites(List<Site> sites) {
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
    	return String.format("Academy [academy_id: "+ String.valueOf(this.academy_id) + 
    			", name: " + this.name + ", tax_id: " + this.tax_id + "]");
    }
	
}
