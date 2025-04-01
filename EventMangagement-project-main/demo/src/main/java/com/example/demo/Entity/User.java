package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String username;

    
    private String email;

    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Event> events;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Event> events = new ArrayList <>();
    
    
       
        
        public User() {}
    
        // Parameterized constructor
        public User(String username, String email) {
            this.username = username;
            this.email = email;
            
        }
    
        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
    
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
    
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    
    //     public String getEvents() { return Event; }
    //     public void setEvents(String Events) { this.Events = Events; }
     public List<Event> getEvents(List<Event> events) {
             return events;
        }
    
        public void setEvents(List<Event> events) {
            this.events = events;
    }
 }