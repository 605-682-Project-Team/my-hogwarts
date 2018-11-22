package edu.hogwarts.web.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.hogwarts.persistence.entity.Course;
import edu.hogwarts.persistence.entity.Course.CourseCategory;
import edu.hogwarts.persistence.repository.CourseRepository;

@Controller
public class CourseController {
	
	private final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping(value="/restricted/course-listing", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView showCourses(HttpServletRequest request) {
		Iterable<Course> courses;
		
		String categoryStr = (String) request.getParameter("category");
		if (categoryStr != null && !categoryStr.isEmpty()) {
			CourseCategory category = CourseCategory.valueOf(categoryStr);
			courses = courseRepository.findAllByCategory(category);
		} else {
			courses = courseRepository.findAll();
		}
		
		request.setAttribute("courses", courses);
		
		return new ModelAndView("restricted/course-listing", new ModelMap());
	}
	
	@RequestMapping(value="/restricted/course-listing/{id}", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView showCourseDetails(HttpServletRequest request, @PathVariable(value="id") final long id) {
		
		Optional<Course> course = courseRepository.findById(id);
		
		if (course.isPresent())
			request.setAttribute("course", course.get());
		else 
			logger.error("Course with id ({}) does not exist!", id);
		
		
		return new ModelAndView("restricted/course-detail", new ModelMap());
	}

}
