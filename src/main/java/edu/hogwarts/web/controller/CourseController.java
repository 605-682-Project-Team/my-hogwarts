package edu.hogwarts.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {
	
	@RequestMapping(value="/restricted/course-listing", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView showCourses(HttpServletRequest request) {
		
		
		return new ModelAndView("restricted/course-listing", new ModelMap());
	}

}
