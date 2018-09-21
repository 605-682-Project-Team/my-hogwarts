package edu.hogwarts.web.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {
	
	private final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@PostConstruct
	private void init() {
		logger.info("The application has started!");
	}
	
	@RequestMapping(value= "", method=RequestMethod.GET)
	public String index() {
		logger.info("The root of the application was accessed!");
		return "index";
	}
	

}
