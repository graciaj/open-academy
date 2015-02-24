/**
 * @author Lehi Gracia
 * @copyright 2014 Lehi Gracia
 */

package com.roundrocklabs.academy.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Academy {

	
	private String academy_id;
	String name;
	String tax_id;
	private List<Site> sites;
	
	
	public Academy(String name2, String tax_id2) {
		this.name = name2;
		this.tax_id = tax_id2;
	}

	public Academy(String name2) {
		this.name = name2;
	}

	public Academy() {
	}

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	public String getAcademy_id() {
		return academy_id;
	}
	public void setAcademy_id(String academy_id) {
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
	

	@OneToMany(mappedBy = "academy", cascade = CascadeType.PERSIST)
	public List<Site> getSites() {
		return sites;
	}
	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
	
	public boolean equals(Academy a){
		return (this.getAcademy_id().equals(a.getAcademy_id()) &&
				this.getName().equals(a.getName()));
	}

		
}
