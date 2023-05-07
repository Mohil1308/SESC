package org.mohil.LBU.studentportal.service;

import java.util.List;

import org.mohil.LBU.studentportal.model.Enrollment;

public interface EnrollmentService {

	List<Enrollment> getEnrollment(String studentId);

	void saveEnrollment(String studentId, String courseId);
}
