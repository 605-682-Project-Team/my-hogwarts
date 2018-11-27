package edu.hogwarts.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import edu.hogwarts.persistence.entity.CourseMaterial;

public interface CourseMaterialRepository extends CrudRepository<CourseMaterial, Long> {
	
	/**
	 * Find the course materials with a particular name.
	 * 
	 * Note: Spring automatically generates the query and method implementation from the method name.
	 * 
	 * @param name
	 * @return CourseMaterials with a name containing (if one exists)
	 */
	public Iterable<CourseMaterial> findAllByNameContaining(String name);

}
