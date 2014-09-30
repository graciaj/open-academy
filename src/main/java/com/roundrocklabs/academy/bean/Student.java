/**
 * @author Lehi Gracia
 * @copyright 2014 Round Rock Labs
 */


package com.roundrocklabs.academy.bean;

public class Student extends Parent {

	public Student() {
		super();
	}

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
