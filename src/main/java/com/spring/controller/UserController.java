package com.spring.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.entity.User;
import com.spring.repository.UserRepository;
import com.spring.service.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    /**
     * Endpoint to retrieve all users.
     * 
     * @return a list of all users
     */
    @GetMapping("/findallusers")
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Endpoint to retrieve a user by their ID.
     * 
     * @param uid the user ID
     * @return an Optional containing the user if found, or empty if not found
     */
    @GetMapping("/getbyid/{uid}")
    public Optional<User> getbyid(@PathVariable int uid) {
        return userService.getbyid(uid);
    }

    /**
     * Endpoint to add a new user.
     * 
     * @param a the user to be added
     * @return the added user
     */
    @PostMapping("/add")
    public User addUser(@RequestBody @Valid User a) {
        return userService.addUser(a);
    }

    /**
     * Alternative endpoint to add a new user directly using UserRepository.
     * 
     * @param a the user to be added
     * @return the added user
     */
    @PostMapping("/adduser")
    public User addUser1(@RequestBody @Valid User a) {
        return userRepository.save(a);
    }

    /**
     * Endpoint to remove a user by their ID.
     * 
     * @param uid the user ID
     */
    @DeleteMapping("/removeruser/{uid}")
    public void removeUser(@PathVariable int uid) {
        this.userService.removeUser(uid);
    }

    /**
     * Endpoint to update an existing user.
     * 
     * @param uid the user ID
     * @param u   the updated user data
     * @return the updated user
     */
    @PutMapping("/updateuser/{uid}")
    public User updateuser(@PathVariable int uid, @RequestBody User u) {
        return userService.updateuser(uid, u);
    }

    /**
     * Endpoint to find users by their full name using path variable.
     * 
     * @param fullName the full name of the user(s) to find
     * @return a list of users with the specified full name
     */
    @GetMapping("/findByUserName/{fullName}")
    public List<User> findUsertName(@PathVariable String fullName) {
        return userService.findByUserName(fullName);
    }

    /**
     * Endpoint to find users by their full name using request parameter.
     * 
     * @param fullName the full name of the user(s) to find
     * @return a list of users with the specified full name
     */
    @GetMapping("/findByUserName1")
    public List<User> findUsertName1(@RequestParam String fullName) {
        return userService.findByUserName(fullName);
    }
}
