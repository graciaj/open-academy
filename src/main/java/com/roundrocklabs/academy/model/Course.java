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
@Table(name = "course")
public class Course {
 
	private Integer course_id;
	String name;
	String description;
	Date start_date;
	Date retire_date;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
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
		
	//TODO: change the info below
	
	@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Course guest = (Course) obj;
        return (this.course_id == guest.course_id || (this.course_id.equals(guest.course_id)))
        		&& (this.name == guest.name  || (this.name != null && this.name.equals(guest.getName())))
                && (this.description == guest.description || (this.description != null && this.description.equals(guest.getDescription())));
    }
   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((name == null) ? 0 : name.hashCode());
        result = prime * result + course_id;
        result = prime * result
                + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    @Override
    public String toString(){
    	return String.format("Course [course_id: "+ String.valueOf(this.course_id) + 
    			", name: " + this.name + ", description: " + this.description + 
    			", start date: " + this.start_date.toString() + 
    			", retire_date: " + this.retire_date.toString() + "]");
    }
	
	
	
}
