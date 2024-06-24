package com.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.User;
import com.spring.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepository;

    /**
     * Retrieves all users from the database.
     * 
     * @return a list of all users
     */
    public List<User> getAllUsers() {
        return userrepository.findAll();
    }

    /**
     * Retrieves a user by their ID.
     * 
     * @param uid the user ID
     * @return an Optional containing the user if found, or empty if not found
     */
    public Optional<User> getbyid(Integer uid) {
        return userrepository.findById(uid);
    }

    /**
     * Adds a new user to the database.
     * 
     * @param a the user to be added
     * @return the added user
     */
    public User addUser(User a) {
        return userrepository.save(a);
    }

    /**
     * Removes a user from the database.
     * 
     * @param uid the ID of the user to be removed
     */
    public void removeUser(int uid) {
        User user = userrepository.getById(uid);
        this.userrepository.delete(user);
    }

    /**
     * Updates an existing user in the database.
     * 
     * @param uid the ID of the user to be updated
     * @param u   the updated user data
     * @return the updated user
     */
    public User updateuser(int uid, User u) {
        u.setUserId(uid);
        return userrepository.save(u);
    }

    /**
     * Finds users by their full name.
     * 
     * @param fullName the full name of the user(s) to find
     * @return a list of users with the specified full name
     */
    public List<User> findByUserName(String fullName) {
        return userrepository.findByFullName(fullName);
    }
}
