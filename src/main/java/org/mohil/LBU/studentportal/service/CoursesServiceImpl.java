package org.mohil.LBU.studentportal.service;

import java.util.List;

import org.mohil.LBU.studentportal.model.Course;
import org.mohil.LBU.studentportal.model.User;
import org.mohil.LBU.studentportal.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CoursesServiceImpl implements CoursesService {

	private CourseRepository courseRepository;

	public CoursesServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	@Override
	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

}
