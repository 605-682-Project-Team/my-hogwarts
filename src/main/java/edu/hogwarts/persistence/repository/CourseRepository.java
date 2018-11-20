package edu.hogwarts.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import edu.hogwarts.persistence.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
