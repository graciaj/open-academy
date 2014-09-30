package com.roundrocklabs.academy.bean;

import java.sql.Date;

public class Room {
	Integer room_id;
	String name;
	String description;
	Integer size;
	Date start_date;
	Date retire_date;
	
	
	public Integer getId() {
		return room_id;
	}
	public void setId(Integer id) {
		this.room_id = id;
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
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
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
