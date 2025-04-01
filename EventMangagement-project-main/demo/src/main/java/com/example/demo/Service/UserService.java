package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;

    // Add a new user
    public User addUser(User user) {
        return userRepo.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // Update user details
    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepo.findById(id);
        
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setEmail(userDetails.getEmail());
            return userRepo.save(existingUser);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    // Delete user by ID
    public String deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return "User deleted successfully!";
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    // Get paginated users
    public Page<User> getPageOrganizers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findAll(pageable);
    } 

    // Get sorted users by username
    public List<User> sortByUsername() {
        return userRepo.findAll(Sort.by("username").ascending());
    }
    //JPI
    public List<User> getByEmail(String email)
    {
        return userRepo.findByEmail(email);
    }
    //JPQL
    public List<User> getByUsername(String username)
    {
        return userRepo.findByUsername(username);
    }
    //mapping
    
    public List<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public List<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
