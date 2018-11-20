package edu.hogwarts.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {
	
	private final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
	
	@RequestMapping(value="/restricted/shopping-cart", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView showCourses(HttpServletRequest request) {
		
		
		return new ModelAndView("restricted/shopping-cart", new ModelMap());
	}

}
