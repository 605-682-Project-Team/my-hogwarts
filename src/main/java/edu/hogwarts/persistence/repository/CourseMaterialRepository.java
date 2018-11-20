package edu.hogwarts.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import edu.hogwarts.persistence.entity.CourseMaterial;

public interface CourseMaterialRepository extends CrudRepository<CourseMaterial, Long> {

}
