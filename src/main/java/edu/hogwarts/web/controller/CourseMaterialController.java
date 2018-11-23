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

import edu.hogwarts.persistence.entity.CourseMaterial;
import edu.hogwarts.persistence.repository.CourseMaterialRepository;

@Controller
public class CourseMaterialController {
	
private final Logger logger = LoggerFactory.getLogger(CourseMaterialController.class);
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@RequestMapping(value="/restricted/course-material-listing", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView showCourses(HttpServletRequest request) {
		Iterable<CourseMaterial> coursesMaterials;
		
		coursesMaterials = courseMaterialRepository.findAll();
		
		request.setAttribute("courseMaterials", coursesMaterials);
		
		return new ModelAndView("restricted/course-material-listing", new ModelMap());
	}

}
