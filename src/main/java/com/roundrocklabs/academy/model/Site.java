/**
 * @author Lehi Gracia
 * @copyright 2014 Lehi Gracia
 */


package com.roundrocklabs.academy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Site {

	Academy academy;
	String siteId;
	String name;
	String description;
	String address1;
	String address2;
	String city;
	String state;
	String zip;
	
	
	@ManyToOne
	public Academy getAcademy() {
		return academy;
	}
	public void setAcademy(Academy academy) {
		this.academy = academy;
	}	
	
	
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}	

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	

}
