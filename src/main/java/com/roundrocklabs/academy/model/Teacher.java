package com.roundrocklabs.academy.model;

import javax.persistence.Entity;


@Entity
public class Teacher extends Person {
	
	Integer teacherId;
	
	
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

}
