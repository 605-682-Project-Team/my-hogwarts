package edu.hogwarts.web.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.hogwarts.persistence.entity.User;
import edu.hogwarts.persistence.repository.UserRepository;

@Controller
public class RootController {
	
	private final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	private void init() {
		logger.info("The application has started!");
	}
	
	@RequestMapping(value= "", method=RequestMethod.GET)
	public String index() {
		logger.info("The root of the application was accessed!");
		
		User user = new User();
		user.setFirstname("John");
		user.setLastname("Smith");
		user.setEmail("john.smith@gmail.com");
		user.setPassword("password123");
		user.setStreetAddress("4 Privet Drive");
		user.setCity("Somewhere");
		user.setState("New York");
		user.setZipcode("21250");
		user.setMuggleborn(false);
		user.setYear(3);
		
		userRepository.save(user);
		
		User user2 = userRepository.findByEmail(user.getEmail());
		
		logger.info("Created new user: " + user2.toString());
		
		return "index";
	}
	

}
