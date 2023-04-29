package org.mohil.LBU.studentportal.service;

import java.util.List;

import org.mohil.LBU.studentportal.model.Enrollment;
import org.mohil.LBU.studentportal.repository.CourseRepository;
import org.mohil.LBU.studentportal.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	private EnrollmentRepository enrollmentRepository;

	public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
		super();
		this.enrollmentRepository = enrollmentRepository;
	}
	
	@Override
	public List<Enrollment> getEnrollment(String studentId) {
		return enrollmentRepository.findByStudentId(studentId);
	}
	
	@Override
	public void saveEnrollment(String studentId, String courseId) {
		Enrollment enrollment= new Enrollment(courseId, studentId);
		enrollmentRepository.save(enrollment);
	}

}
