package edu.hogwarts.persistence.repository;

import edu.hogwarts.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Find the user entity by email address.
     * <p>
     * Note: Spring automatically generates the query and method implementation from the method name.
     *
     * @param email
     * @return User with email address (if one exists)
     */
    User findByEmail(String email);
}
