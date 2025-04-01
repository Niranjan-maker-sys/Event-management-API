package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // Get all users
    @GetMapping("/get")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get users with pagination and sorting
    @GetMapping("/getPaged")
    public Page<User> getUsersPaged(int page,int size) {
        return userService.getPageOrganizers(page,size);
    }

    // Get user by email using JPA
    @GetMapping("/findByEmail/{email}")
    public List<User> getUsersByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    // Get user by username using JPQL
    @GetMapping("/findByUsername/{username}")
    public List<User> getUsersByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }


    // Update a user by ID
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Delete a user by ID
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
