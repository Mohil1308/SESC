package org.mohil.LBU.studentportal.service;

import java.util.List;

import org.mohil.LBU.studentportal.model.Course;
import org.springframework.stereotype.Service;


public interface CoursesService {

	List<Course> getCourses();

}
