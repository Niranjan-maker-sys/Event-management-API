package com.example.demo.Controller;

import com.example.demo.Entity.Organizer;
import com.example.demo.Service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {
    
    @Autowired
    private OrganizerService organizerService;

    // Create a new organizer
    @PostMapping("/add")
    public Organizer createOrganizer(@RequestBody Organizer organizer) {
        return organizerService.addOrganizer(organizer);
    }

    // Get all organizers
    @GetMapping("/get")
    public List<Organizer> getAllOrganizers() {
        return organizerService.getAllOrganizers();
    }

    // Get organizers with pagination and sorting
    @GetMapping("/getPaged")
    public Page<Organizer> getOrganizersPaged(int Page,int size) {
        return organizerService.getPageOrganizers(Page,size);
    }

    // // Get organizer by name using JPA
    // @GetMapping("/findByName/{name}")
    // public List<Organizer> getOrganizersByName(@PathVariable String name) {
    //     return organizerService.findOrganizersByNameJPA(name);
    // }

    // // Get organizer by role using JPQL
    // @GetMapping("/findByRole/{role}")
    // public List<Organizer> getOrganizersByRole(@PathVariable String role) {
    //     return organizerService.findOrganizersByRoleJPQL(role);
    // }

    // Update an organizer by ID
    @PutMapping("/update/{id}")
    public Organizer updateOrganizer(@PathVariable Long id, @RequestBody Organizer organizer) {
        return organizerService.updateOrganizer(id, organizer);
    }

    // Delete an organizer by ID
    @DeleteMapping("/delete/{id}")
    public String deleteOrganizer(@PathVariable Long id) {
        return organizerService.deleteOrganizer(id);
    }
    // Get organizers by name using JPA
    @GetMapping("/findByName/{name}")
    public List<Organizer> getOrganizersByName(@PathVariable String name) {
        return organizerService.findOrganizersByNameJPA(name);
    }

    // Get organizers by role using JPQL
    @GetMapping("/findByRole/{role}")
    public List<Organizer> getOrganizersByRole(@PathVariable String role) {
        return organizerService.findOrganizersByRoleJPQL(role);
    }
}
