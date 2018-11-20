package edu.hogwarts.web.controller;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.hogwarts.persistence.entity.User;
import edu.hogwarts.persistence.repository.UserRepository;
import edu.hogwarts.util.HogwartsConstants;

@Controller
public class RootController {
	
	private final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${web.session.timeout}")
	private int sessionTimeoutInterval;
	
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
			return "restricted/dashboard";
		} else {
			// the user has not logged in, show login screen
			logger.info("The user is not logged in, showing login page.");
			return "login";
		}
	}
	
	@RequestMapping(value= "/register", method= {RequestMethod.GET, RequestMethod.POST})
	public String register(HttpSession session) {
		return "register";
	}
	
	@RequestMapping(value= "/login", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		logger.info("The user ({}) is attempting to login.");
		
		// find the user
		User user = userRepository.findByEmail(email);
		
		if (user != null) {
			if (user.getPassword().equals(password)) {
				logger.info("The user ({}) has succesfully logged in!", email);
				session.setAttribute(HogwartsConstants.ATTRIBUTE_CURRENT_USER, user);
				session.setMaxInactiveInterval(sessionTimeoutInterval);
				
				return new ModelAndView("redirect:/restricted/dashboard", new HashMap<String, Object>());
			}
		} else {
			logger.error("{} attempted to log in, but the user does not exists!", email);
		}
		return new ModelAndView("redirect:/login", new HashMap<String, Object>());
	}
	
	@RequestMapping(value= "/logout", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/", new HashMap<String, Object>());
	}
	
	@RequestMapping(value= "/restricted/dashboard", method= {RequestMethod.GET, RequestMethod.POST})
	public String restrictedPages(HttpServletRequest request, HttpSession session) {
		return "restricted/dashboard";
	}
}
