package org.mohil.LBU.studentportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "course", uniqueConstraints = @UniqueConstraint(columnNames = "course_id"))
public class Course {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
 
	@Column(name = "course_id")
	private String courseId;
	
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "course_fee")
	private float courseFee;
	
	
	
	public Course() {
		super();
	}

	public Course(String courseId, String courseName, float courseFee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFee = courseFee;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public float getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(float courseFee) {
		this.courseFee = courseFee;
	}
	
	
	
	
}
