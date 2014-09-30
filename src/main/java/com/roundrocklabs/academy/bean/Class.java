package com.roundrocklabs.academy.bean;

import java.sql.Date;

public class Class {
	Integer class_id;
	String name;
	String description;
	Integer academy_id;
	Date start_date;
	Date retire_date;
	
	
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
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
	public Integer getAcademy_id() {
		return academy_id;
	}
	public void setAcademy_id(Integer academy_id) {
		this.academy_id = academy_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getRetire_date() {
		return retire_date;
	}
	public void setRetire_date(Date retire_date) {
		this.retire_date = retire_date;
	}
		
	
}
