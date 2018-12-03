package edu.hogwarts.persistence.repository;

import edu.hogwarts.persistence.entity.Course;
import edu.hogwarts.persistence.entity.Course.CourseCategory;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

    /**
     * Find the courses in a particular category.
     * <p>
     * Note: Spring automatically generates the query and method implementation from the method name.
     *
     * @param category
     * @return Courses with category (if one exists)
     */
    Iterable<Course> findAllByCategory(CourseCategory category);

    /**
     * Find the courses with a particular name.
     * <p>
     * Note: Spring automatically generates the query and method implementation from the method name.
     *
     * @param name
     * @return Courses with name (if one exists)
     */
    Iterable<Course> findAllByName(String name);

}
