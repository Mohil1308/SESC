package org.mohil.LBU.studentportal.repository;

import org.mohil.LBU.studentportal.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long>{
       
	Course findByCourseId(String courseId);
}
