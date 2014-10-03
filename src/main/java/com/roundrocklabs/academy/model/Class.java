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


@Entity
@Table(name = "class")
public class Class {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Integer class_id;
	
	@Column 
	private String name;
	
	@Column 
	private String description;
	
	@Column 
	private Date start_date;
	
	@Column
	private Date retire_date;
	
	
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
