package com.example.demo.Controller;

import com.example.demo.Entity.Venue;
import com.example.demo.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venues")
public class VenueController {                                                                                                                                                                                                                                                                                                                              
    
    @Autowired
    private VenueService venueService;

    // Create a new venue
    @PostMapping("/add")
    public Venue createVenue(@RequestBody Venue venue) {
        return venueService.addVenue(venue);
    }

    // Get all venues
    @GetMapping("/get")
    public List<Venue> getAllVenues() {
        return venueService.getAllVenues();
    }

    // Get venues with pagination and sorting
    @GetMapping("/getPaged")
    public Optional<Venue> getVenuesPaged(Long id) {
        return VenueService.getAllVenueByID(id);
    }

    // Get venue by name using JPA
    @GetMapping("/findByName/{name}")
    public List<Venue> getByName(@PathVariable String name) {
        return VenueService.getByName(name);
    }

    // Get venue by location using JPQL
    @GetMapping("/findByLocation/{location}")
    public List<Venue> getByLocation(@PathVariable String location) {
        return VenueService.getByLocation(location);
    }

    // Update a venue by ID
    @PutMapping("/update/{id}")
    public Venue updateVenue(@PathVariable Long id, @RequestBody Venue venue) {
        return venueService.updateVenue(id, venue);
    }

    // Delete a venue by ID
    @DeleteMapping("/delete/{id}")
    public boolean deleteVenue(@PathVariable Long id) {
        return venueService.deleteVenue(id);
    }
}
