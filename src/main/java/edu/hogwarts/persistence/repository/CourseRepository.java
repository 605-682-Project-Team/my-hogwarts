package edu.hogwarts.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import edu.hogwarts.persistence.entity.Course;
import edu.hogwarts.persistence.entity.Course.CourseCategory;

public interface CourseRepository extends CrudRepository<Course, Long> {
	
	/**
	 * Find the courses in a particular category.
	 * 
	 * Note: Spring automatically generates the query and method implementation from the method name.
	 * 
	 * @param category
	 * @return Courses with category (if one exists)
	 */
	public Iterable<Course> findAllByCategory(CourseCategory category);

}
