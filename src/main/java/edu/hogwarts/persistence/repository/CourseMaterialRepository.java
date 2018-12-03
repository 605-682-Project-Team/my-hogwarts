package edu.hogwarts.persistence.repository;

import edu.hogwarts.persistence.entity.CourseMaterial;
import org.springframework.data.repository.CrudRepository;

public interface CourseMaterialRepository extends CrudRepository<CourseMaterial, Long> {

    /**
     * Find the course materials with a particular name.
     * <p>
     * Note: Spring automatically generates the query and method implementation from the method name.
     *
     * @param name
     * @return CourseMaterials with a name containing (if one exists)
     */
    Iterable<CourseMaterial> findAllByNameContaining(String name);

}
