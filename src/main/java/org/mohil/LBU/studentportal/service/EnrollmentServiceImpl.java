package org.mohil.LBU.studentportal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mohil.LBU.studentportal.model.Course;
import org.mohil.LBU.studentportal.model.Enrollment;
import org.mohil.LBU.studentportal.repository.CourseRepository;
import org.mohil.LBU.studentportal.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	private EnrollmentRepository enrollmentRepository;
	
	private CourseRepository courseRepository;

	public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository) {
		super();
		this.enrollmentRepository = enrollmentRepository;
		this.courseRepository = courseRepository;
	}
	
	@Override
	public List<Enrollment> getEnrollment(String studentId) {
		return enrollmentRepository.findByStudentId(studentId);
	}
	
	@Override
	public void saveEnrollment(String studentId, String courseId) {
		Enrollment enrollment= new Enrollment(courseId, studentId);
		enrollmentRepository.save(enrollment);
		
		Course course = courseRepository.findByCourseId(courseId);
		// Enrolling to course with invoice
		
		 Map requestBodyMap = new HashMap<>();
		 requestBodyMap.put("amount", course.getCourseFee());
		 requestBodyMap.put("dueDate", "2023-11-06");
		 requestBodyMap.put("type", "TUITION_FEES");

		 Map requestBodyMap2 = new HashMap<>();
		 requestBodyMap2.put("studentId", studentId);
		 requestBodyMap.put("account", requestBodyMap2);
	
		
		RestTemplate restTemplate = new RestTemplate();
		  
		  restTemplate.postForObject("http://localhost:8081/invoices/", requestBodyMap, Map.class);
	}

}
