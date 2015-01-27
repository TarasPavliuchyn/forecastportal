package com.forecastportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LoginController {

	@RequestMapping("/login")
	public String login(Model model, @RequestParam(required=false) String message) {
		model.addAttribute("message", message);
		return "access/login";
	}
	
	
	@RequestMapping(value = "/login/failure")
 	public String loginFailure() {
		String message = "fail";
		return "redirect:/login?message="+message;
	}
	
	@RequestMapping(value = "/logout/success")
 	public String logoutSuccess() {
		String message = "logout";
		return "redirect:/login?message="+message;
	}
}