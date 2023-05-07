package org.mohil.LBU.studentportal.repository;

import java.util.List;

import org.mohil.LBU.studentportal.model.Course;
import org.mohil.LBU.studentportal.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository  extends JpaRepository<Enrollment, Long>{

	
	List<Enrollment> findByStudentId(String studentId);
}
