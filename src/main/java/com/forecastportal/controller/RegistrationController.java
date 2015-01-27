package com.forecastportal.controller;

import java.util.Date;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.forecastportal.domain.user.Role;
import com.forecastportal.domain.user.User;
import com.forecastportal.service.registration.RegistrationService;
import com.forecastportal.service.user.UserService;

@Controller
public class RegistrationController {

	@Autowired
	public UserService userService;

	@Autowired
	public RegistrationService registrationService;

	@RequestMapping(value = "/registr", method = RequestMethod.GET)
	public String goToRegistr(Model model,
			@RequestParam(required = false) String message) {
		model.addAttribute("newUser", new User());
		model.addAttribute("message", message);
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String postRegisterPage(@ModelAttribute("newUser") User newUser,
			Model model, HttpServletRequest request) {
		if (userService.findByEmail(newUser.getEmail()) != null) {
			String message = "exist";
			return "redirect:/registr?message=" + message;
		}
		
		userService.create(fillUser(newUser));
		registrationService.sendRegistrationEmail(newUser, request
				.getRequestURL().toString());
		model.addAttribute("message", "please.login");
		return "redirect:/login";

	}

	@RequestMapping(value = "/registration/activation", method = RequestMethod.GET)
	public String activateAccount(HttpServletRequest request,
			@ModelAttribute(value = "confirm") String confirm,
			RedirectAttributes attrs)
			throws NoSuchRequestHandlingMethodException {
		if (confirm == null || confirm.isEmpty() || confirm.length() > 1000) {
			throw new IllegalArgumentException("Bad input param.");
		}

		registrationService.activateAccount(confirm);
		//attrs.addFlashAttribute("msg", "activated");
		return "redirect:/";
	}

	private User fillUser(User user) {
		user.setActivated(Boolean.FALSE);
		user.setCreationTime(new Date());
		user.setRole(Role.CUSTOMER);
		return user;
	}

}