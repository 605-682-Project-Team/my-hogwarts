package edu.hogwarts.web.controller;

import edu.hogwarts.persistence.entity.CourseMaterial;
import edu.hogwarts.persistence.repository.CourseMaterialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class CourseMaterialController {

    private final Logger logger = LoggerFactory.getLogger(CourseMaterialController.class);

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @RequestMapping(value = "/restricted/course-material-listing", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showCourses(HttpServletRequest request) {
        Iterable<CourseMaterial> courseMaterials;

        String courseMaterialName = request.getParameter("courseMaterialName");
        if (courseMaterialName != null && !courseMaterialName.isEmpty()) {
            courseMaterials = courseMaterialRepository.findAllByNameContaining(courseMaterialName);
        } else {
            courseMaterials = courseMaterialRepository.findAll();
        }

        request.setAttribute("courseMaterials", courseMaterials);

        return new ModelAndView("restricted/course-material-listing", new ModelMap());
    }

    @RequestMapping(value = "/restricted/course-material-listing/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showCourseDetails(HttpServletRequest request, @PathVariable(value = "id") final long id) {

        Optional<CourseMaterial> course = courseMaterialRepository.findById(id);

        if (course.isPresent())
            request.setAttribute("courseMaterial", course.get());
        else
            logger.error("CourseMaterial with id ({}) does not exist!", id);


        return new ModelAndView("restricted/course-material-detail", new ModelMap());
    }

}
