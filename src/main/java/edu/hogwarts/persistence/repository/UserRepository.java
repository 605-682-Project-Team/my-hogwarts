package edu.hogwarts.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import edu.hogwarts.persistence.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	/**
	 * Find the user entity by email address.
	 * 
	 * Note: Spring automatically generates the query and method implementation from the method name.
	 * 
	 * @param email
	 * @return User with email address (if one exists)
	 */
	public User findByEmail(String email);
}
