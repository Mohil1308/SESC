package org.mohil.LBU.studentportal.web;

import org.mohil.LBU.studentportal.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradutionController {
	
	private UserService userService;

	public GradutionController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/students/graduation")
	public String editStudentForm(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user ,Model model) {
		
		model.addAttribute("studentHasNotGraduated", userService.sutdetHasNotGraduated(user.getUsername()));
		return "graduation";
	}
 
}
