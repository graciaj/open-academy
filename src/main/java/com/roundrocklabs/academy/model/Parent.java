/**
 * @author Lehi Gracia
 * @copyright 2014 Lehi Gracia
 */

package com.roundrocklabs.academy.model;

import javax.persistence.Entity;

@Entity
public class Parent extends Person {

	
	Integer studentId;
	Integer parentId;
	
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
}
