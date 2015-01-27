package com.forecastportal.service.registration;

import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.forecastportal.domain.user.User;
import com.forecastportal.service.user.UserService;
import com.forecastportal.util.TokenService;

@Service
public class RegistrationService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserService userService;

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private TokenService tokenService;

	public void sendRegistrationEmail(User user, String baseUrl) {

		ResourceBundle rb = ResourceBundle.getBundle("email");

		String subject = rb.getString("registrationEmail.subject");
		String message = rb.getString("registrationEmail.message");

		sendEmail(user, baseUrl, subject, message,
				createLinkForActivation(user, baseUrl));

	}

	private void sendEmail(User user, String baseUrl, String subject,
			String message, String link) {

		Resource image = appContext.getResource("img/logo.jpg");

		MimeMessage email = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(email, true);
			System.out.println("\"");
			helper.setTo(user.getEmail());
			helper.setSubject(subject);
			helper.setText(
					"<html><body><img src=\"cid:image\"><br>Dear "
							+ user.getFname()
							+ ",<br><br>"
							+ message
							+ "<a href=\""
							+ link
							+ "\" style=\"color:#2ab8e7;font-weight:bold\" >CLICK HERE</a>"
							+ "<br><br>With best regards,"
							+ "<br>Forecast Portal<br><hr><h6>This message was generated automatically."
							+ " Please, do not reply!</h6></body></html>", true);
			helper.addInline("image", image);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		mailSender.send(email);
	}

	private String createLinkForActivation(User user, String baseUrl) {
		return baseUrl + "/activation?confirm="
				+ tokenService.createToken(user);
	}

	public void activateAccount(String confirmString) {
		User user = tokenService.getUserFromLink(confirmString);
		userService.activateUser(user.getId());
	}
}
