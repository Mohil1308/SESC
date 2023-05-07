package org.mohil.LBU.studentportal.service;

import java.util.Map;

import org.mohil.LBU.studentportal.model.User;
import org.mohil.studentportal.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
	User save(org.mohil.studentportal.web.dto.UserRegistrationDto registrationDto);
    User getStudentById(String studentId);
	
	User updateStudent(User student);
	boolean sutdetHasNotGraduated(String studentId);
}
