package org.mohil.LBU.studentportal.web;

import java.security.Principal;

import org.mohil.LBU.studentportal.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


public class StudentController {

	private org.mohil.LBU.studentportal.service.UserService userService;

	public StudentController(org.mohil.LBU.studentportal.service.UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/students/profile")
	public String editStudentForm(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user ,Model model) {
		
		model.addAttribute("user", userService.getStudentById(user.getUsername()));
		return "profile";
	}

	@PostMapping("/students/profile")
	public String updateStudent(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user ,
			@ModelAttribute("user") User student,
			Model model) {
		
		// get student from database by id
		User existingStudent = userService.getStudentById(user.getUsername());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		userService.updateStudent(existingStudent);
		return "redirect:/students/profile";		
	}
	
}
