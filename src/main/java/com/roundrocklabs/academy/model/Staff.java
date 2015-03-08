package com.roundrocklabs.academy.model;

import javax.persistence.Entity;


@Entity
public class Staff extends Person {

	Integer staffId;
	
	
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	
	
}
