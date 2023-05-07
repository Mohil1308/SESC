package org.mohil.LBU.studentportal.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.mohil.LBU.studentportal.model.Role;
import org.mohil.LBU.studentportal.model.User;
import org.mohil.LBU.studentportal.repository.UserRepository;
import org.mohil.studentportal.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(org.mohil.studentportal.web.dto.UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		
		 user = userRepository.save(user);
		
	
		 Map requestBodyMap = new HashMap<>();
		 requestBodyMap.put("studentId", user.getStudentId());
		 
		 
		  RestTemplate restTemplate = new RestTemplate();
		  
		  // Finance Service Called
		  restTemplate.postForObject("http://localhost:8081/accounts", requestBodyMap, Map.class);
		  // library Service Called
		  restTemplate.postForObject("http://localhost:80/api/register", requestBodyMap, Map.class);
		  
		 
		return user;
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getStudentId(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	@Override
	public User getStudentById(String studentId) {
		return userRepository.findByStudentId(studentId);
	}
	@Override
	public User updateStudent(User student) {
		return userRepository.save(student);
	}
	@Override
	public boolean sutdetHasNotGraduated(String studentId) {
		
		String uri = "http://localhost:8081/accounts/student/"+studentId;
		  RestTemplate restTemplate = new RestTemplate();
		  
		  Map responseMap = restTemplate.getForObject(uri, Map.class);
		  boolean hasOutstandingBalance = (boolean) responseMap.get("hasOutstandingBalance");
		  
		  return hasOutstandingBalance;
	}

}
