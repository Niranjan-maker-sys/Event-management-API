package com.example.demo.Entity;

 import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
 
 @Entity
 @Table(name="organizers")
 public class Organizer{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)

    private String name;
    private String role;

    // @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Event> event;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Event> events = new ArrayList <>();
    
    //default constructor
    public Organizer() {}
    
    //parameterized constructor
    public Organizer(String name,String role) {
        this.name=name;
        this.role=role;
    }
    //getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id)
    {
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getrole(){
        return role;
    }
    public void setrole(String role){
        this.role=role;
    }
    public List<Event> getEvents() {
        return events;
    }

    public void setEvent(List<Event> event) {
        this.events = event;
    }
    
    
 }