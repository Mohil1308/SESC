package org.mohil.LBU.studentportal.service;

import org.mohil.LBU.studentportal.model.User;
import org.mohil.LBU.studentportal.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
