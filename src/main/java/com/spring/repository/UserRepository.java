package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.User;

/**
 * UserRepository is an interface that extends JpaRepository to provide CRUD
 * operations on User entities.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * Finds users by their full name.
	 * 
	 * @param fullName the full name of the user(s) to find
	 * @return a list of users with the specified full name
	 */
	public List<User> findByFullName(String fullName);
}
