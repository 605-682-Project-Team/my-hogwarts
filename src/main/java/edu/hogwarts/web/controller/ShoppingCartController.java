package edu.hogwarts.web.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.hogwarts.persistence.entity.Course;
import edu.hogwarts.persistence.repository.CourseRepository;
import edu.hogwarts.util.HogwartsConstants;
import edu.hogwarts.util.ShoppingCart;

@Controller
public class ShoppingCartController {
	
	private final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
	
	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping(value="/restricted/shopping-cart", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView showCourses(HttpServletRequest request) {
		
		
		return new ModelAndView("restricted/shopping-cart", new ModelMap());
	}
	
	@RequestMapping(value="/restricted/shopping-cart/add-course/{id}", method= {RequestMethod.POST})
	public ModelAndView addCourseToCart(HttpServletRequest request, @PathVariable(value="id") long id) {
		
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent()) {
			ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART);
			if (shoppingCart == null) {
				shoppingCart = new ShoppingCart();
			}
			
			shoppingCart.add(course.get());
			request.getSession().setAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART, shoppingCart);
		}
		
		return new ModelAndView(new RedirectView(request.getHeader(HttpHeaders.REFERER)));
	}

}
