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

	
	private String academyId;
	String name;
	String taxId;
	private List<Site> sites;
	
	
	public Academy(String name2, String taxId2) {
		this.name = name2;
		this.taxId = taxId2;
	}

	public Academy(String name2) {
		this.name = name2;
	}

	public Academy() {
	}

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	public String getAcademyId() {
		return academyId;
	}
	public void setAcademyId(String academyId) {
		this.academyId = academyId;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	

	@OneToMany(mappedBy = "academy", cascade = CascadeType.PERSIST)
	public List<Site> getSites() {
		return sites;
	}
	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	

	public boolean equals(Academy a){
		return this.getAcademyId().equals(a.getAcademyId()) &&
				this.getName().equals(a.getName());
	}
		
}
