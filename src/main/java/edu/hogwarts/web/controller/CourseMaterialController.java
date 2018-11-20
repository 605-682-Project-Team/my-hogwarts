package edu.hogwarts.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseMaterialController {
	
	@RequestMapping(value="/restricted/course-material-listing", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView showCourseMaterials(HttpServletRequest request) {
		
		
		return new ModelAndView("restricted/course-material-listing", new ModelMap());
	}

}
