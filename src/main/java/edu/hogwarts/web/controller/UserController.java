package edu.hogwarts.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.hogwarts.persistence.entity.User;
import edu.hogwarts.persistence.repository.UserRepository;

@Controller
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/user/create", method=RequestMethod.POST)
	public ModelAndView createUser(HttpServletRequest request) {
		logger.info("Attempting to create new user.");
		User user = new User();
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password")); // TODO this should be hashed and stored
		user.setStreetAddress(request.getParameter("streetAddress"));
		user.setCity(request.getParameter("city"));
		user.setState(request.getParameter("state"));
		user.setZipcode(request.getParameter("zipcode"));
		user.setYear(Integer.parseInt(request.getParameter("year")));
		user.setMuggleborn(request.getParameter("muggleBorn") == "true");
		userRepository.save(user);
		logger.info("Created user - {}", user.getEmail());
		
		// TODO set message that user was created successfully
		
		return new ModelAndView("redirect:/", new ModelMap());
	}
	

}
