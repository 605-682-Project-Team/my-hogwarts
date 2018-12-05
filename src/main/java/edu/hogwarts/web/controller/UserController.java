package edu.hogwarts.web.controller;

import edu.hogwarts.persistence.entity.User;
import edu.hogwarts.persistence.repository.UserRepository;
import edu.hogwarts.util.HogwartsConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ModelAndView createUser(HttpServletRequest request) {
        logger.info("Attempting to create new user.");
        User user = new User();
        userRepository.save(setUserAttributes(user, request));
        logger.info("Created user - {}", user.getEmail());

        // TODO set message that user was created successfully

        return new ModelAndView("redirect:/", new ModelMap());
    }

    @RequestMapping(value = "/restricted/user/update", method = RequestMethod.POST)
    public ModelAndView updateUser(HttpServletRequest request) {
        logger.info("Updating user.");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(HogwartsConstants.ATTRIBUTE_CURRENT_USER);
        userRepository.save(setUserAttributes(user, request));
        logger.info("Updated user - {}", user.getEmail());

        return new ModelAndView("redirect:/", new ModelMap());
    }

    @RequestMapping(value = "/restricted/account", method = {RequestMethod.GET})
    public ModelAndView showUserAccount(HttpServletRequest request) {
        return new ModelAndView("restricted/edit-registration", new ModelMap());
    }

    private User setUserAttributes(User user, HttpServletRequest request) {
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
        return user;
    }


}
