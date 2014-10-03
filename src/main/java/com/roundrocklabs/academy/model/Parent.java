/**
 * @author Lehi Gracia
 * @copyright 2014 Lehi Gracia
 */

package com.roundrocklabs.academy.model;

public class Parent extends Person {

	public Parent() {
		super();
	}
	
	Integer parent_id;
	Integer student_id;
	Integer id;
	
	
	public Integer getPerson_id() {
		return parent_id;
	}
	public void setPerson_id(Integer person_id) {
		this.parent_id = person_id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
