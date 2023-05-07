package org.mohil.LBU.studentportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "enrollment", uniqueConstraints = @UniqueConstraint(columnNames = {"course_id", "student_id"}))
public class Enrollment {
 
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
 
	@Column(name = "course_id")
	private String courseId;
	
	@Column(name = "student_id")
	private String studentId;

	
	
	public Enrollment() {
		super();
	}

	public Enrollment(String courseId, String studentId) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
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

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	

	


}
