package edu.hogwarts.web.controller;

import edu.hogwarts.persistence.entity.Course;
import edu.hogwarts.persistence.entity.CourseMaterial;
import edu.hogwarts.persistence.repository.CourseMaterialRepository;
import edu.hogwarts.persistence.repository.CourseRepository;
import edu.hogwarts.util.HogwartsConstants;
import edu.hogwarts.util.ShoppingCart;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class ShoppingCartController {

    private final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @RequestMapping(value = "/restricted/shopping-cart", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showCourses(HttpServletRequest request) {


        return new ModelAndView("restricted/shopping-cart", new ModelMap());
    }

    @RequestMapping(value = "/restricted/shopping-cart/add-course/{id}", method = {RequestMethod.POST})
    public ModelAndView addCourseToCart(HttpServletRequest request, @PathVariable(value = "id") long id) {

        logger.debug("Adding course with id({}) to cart", id);

        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART);
            if (shoppingCart == null) {
                shoppingCart = new ShoppingCart();
            }

            shoppingCart.add(course.get());
            request.getSession().setAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART, shoppingCart);
        } else {
            logger.error("Course with id({}) does not exist!", id);
        }

        return new ModelAndView(new RedirectView(request.getHeader(HttpHeaders.REFERER)));
    }

    @RequestMapping(value = "/restricted/shopping-cart/remove-course/{id}", method = {RequestMethod.POST})
    public ModelAndView removeCourseToCart(HttpServletRequest request, @PathVariable(value = "id") long id) {

        logger.debug("Removing course with id({}) to cart", id);

        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART);
            if (shoppingCart == null) {
                shoppingCart = new ShoppingCart();
            }

            shoppingCart.remove(course.get());
            request.getSession().setAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART, shoppingCart);
        } else {
            logger.error("Course with id({}) does not exist!", id);
        }

        return new ModelAndView(new RedirectView(request.getHeader(HttpHeaders.REFERER)));
    }

    @RequestMapping(value = "/restricted/shopping-cart/add-course-material/{id}", method = {RequestMethod.POST})
    public ModelAndView addCourseMaterialToCart(HttpServletRequest request, @PathVariable(value = "id") long id) {

        logger.debug("Adding course material with id({}) to cart", id);

        Optional<CourseMaterial> courseMaterial = courseMaterialRepository.findById(id);
        if (courseMaterial.isPresent()) {
            ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART);
            if (shoppingCart == null) {
                shoppingCart = new ShoppingCart();
            }

            shoppingCart.add(courseMaterial.get());
            request.getSession().setAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART, shoppingCart);
        } else {
            logger.error("CourseMaterial with id({}) does not exist!", id);
        }

        return new ModelAndView(new RedirectView(request.getHeader(HttpHeaders.REFERER)));
    }

    @RequestMapping(value = "/restricted/shopping-cart/update-course-material/{id}", method = {RequestMethod.POST})
    public ModelAndView updateQuantityCourseMaterialToCart(HttpServletRequest request, @PathVariable(value = "id") long id) {

        logger.debug("Updating quantity course material with id({}) to cart", id);

        Optional<CourseMaterial> courseMaterial = courseMaterialRepository.findById(id);
        if (courseMaterial.isPresent()) {
            ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART);
            if (shoppingCart == null) {
                shoppingCart = new ShoppingCart();
            }

            Integer quantity = Integer.valueOf(request.getParameter("quantity"));

            shoppingCart.updateQuantity(courseMaterial.get(), quantity);
            request.getSession().setAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART, shoppingCart);
        } else {
            logger.error("CourseMaterial with id({}) does not exist!", id);
        }

        return new ModelAndView(new RedirectView(request.getHeader(HttpHeaders.REFERER)));
    }

    @RequestMapping(value = "/restricted/shopping-cart/remove-course-material/{id}", method = {RequestMethod.POST})
    public ModelAndView removeCourseMaterialToCart(HttpServletRequest request, @PathVariable(value = "id") long id) {

        logger.debug("Removing course material with id({}) to cart", id);

        Optional<CourseMaterial> courseMaterial = courseMaterialRepository.findById(id);
        if (courseMaterial.isPresent()) {
            ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART);
            if (shoppingCart == null) {
                shoppingCart = new ShoppingCart();
            }

            shoppingCart.remove(courseMaterial.get());
            request.getSession().setAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART, shoppingCart);
        } else {
            logger.error("CourseMaterial with id({}) does not exist!", id);
        }

        return new ModelAndView(new RedirectView(request.getHeader(HttpHeaders.REFERER)));
    }

    @RequestMapping(value = "/restricted/shopping-cart/checkout", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView checkout(HttpServletRequest request) {

        logger.debug("Checking out...");

        return new ModelAndView("restricted/checkout", new ModelMap());
    }

    @RequestMapping(value = "/restricted/shopping-cart/confirmation", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView confirmation(HttpServletRequest request) {

        logger.debug("Placing order...");
        
        // order complete, clear shopping cart from session
        ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART);
        request.getSession().removeAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART);
        
        // include as request attribute to display in confirmation view
        request.setAttribute(HogwartsConstants.ATTRIBUTE_SHOPPING_CART, shoppingCart);

        return new ModelAndView("restricted/confirmation", new ModelMap());
    }

}
