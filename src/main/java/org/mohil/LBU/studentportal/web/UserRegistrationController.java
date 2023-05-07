package org.mohil.LBU.studentportal.web;

import org.mohil.LBU.studentportal.service.UserService;
import org.mohil.studentportal.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public org.mohil.studentportal.web.dto.UserRegistrationDto userRegistrationDto() {
        return new org.mohil.studentportal.web.dto.UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") org.mohil.studentportal.web.dto.UserRegistrationDto registrationDto) {
		try {
		userService.save(registrationDto);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/registration?error="+"User is already exist.";
		}
		return "redirect:/registration?success";
	}
	
}
