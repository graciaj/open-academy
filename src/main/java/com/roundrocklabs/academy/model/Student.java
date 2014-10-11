/**
 * @author Lehi Gracia
 * @copyright 2014 Lehi Gracia
 */


package com.roundrocklabs.academy.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class Student extends Person {
	
	Integer student_id;	
	Integer parent_id;
	
	
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	
	
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	
}
