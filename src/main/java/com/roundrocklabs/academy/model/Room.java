/**
 * @author Lehi Gracia
 * @copyright 2014 Lehi Gracia
 */


package com.roundrocklabs.academy.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Room {
	
	
	String room_id;
	String name;
	String description;
	Integer size;
	Date start_date;
	Date retire_date;
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String id) {
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
