package edu.hogwarts.web.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.hogwarts.persistence.entity.User;
import edu.hogwarts.persistence.repository.UserRepository;
import edu.hogwarts.util.HogwartsConstants;

@Controller
public class RootController {
	
	private final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	private void init() {
		logger.info("The application has started!");
	}
	
	@RequestMapping(value= "", method= {RequestMethod.GET, RequestMethod.POST})
	public String index(HttpSession session) {
		logger.info("The root of the application was accessed!");
		
		User user = (User) session.getAttribute(HogwartsConstants.ATTRIBUTE_CURRENT_USER);
		if (user != null) {
			logger.info("The user {} is already logged in, show their dashboard.", user.getEmail());
			return "dashboard";
		} else {
			// the user has not logged in, show login screen
			logger.info("The user is not logged in, showing login page.");
			return "login";
		}
	}
	
	@RequestMapping(value= "/login", method= {RequestMethod.POST})
	public String login(HttpServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		logger.info("The user ({}) is attempting to login.");
		
		// find the user
		User user = userRepository.findByEmail(email);
		
		if (user != null) {
			if (user.getPassword().equals(password)) {
				logger.info("The user ({}) has succesfully logged in!", email);
				session.setAttribute(HogwartsConstants.ATTRIBUTE_CURRENT_USER, user);
				return "dashboard";
			}
		} else {
			// TODO error the user does not exist!
		}
		return "login";
	}
}
