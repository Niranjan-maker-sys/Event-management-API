package com.example.demo.Service;

import com.example.demo.Entity.Venue;
import com.example.demo.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    @Autowired
    private static VenueRepository venueRepository;
    
        // Create a new venue
        public Venue addVenue(Venue venue) {
            return venueRepository.save(venue);
        }
    
        // Get all venues
        public List<Venue> getAllVenues() {
            return venueRepository.findAll();
        }
    
        // Get venue by ID
        public static Optional<Venue> getAllVenueByID(Long id){
            return venueRepository.findById(id);
        }
    

    // Update venue details
    public Venue updateVenue(Long id, Venue venueDetails) {
        Optional<Venue> existingVenue = venueRepository.findById(id);
        if (existingVenue.isPresent()) {
            Venue venue = existingVenue.get();
            venue.setName(venueDetails.getName());
            venue.setLocation(venueDetails.getLocation());
            venue.setCapacity(venueDetails.getCapacity());
            return venueRepository.save(venue);
        }
        return null;
    }

    // Delete venue by ID
    public boolean deleteVenue(Long id) {
        if (venueRepository.existsById(id)) {
            venueRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Get paginated venues
    public Page<Venue> getPageVenues(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return venueRepository.findAll(pageable);
    }

    // Get sorted venues by a specific field
    public List<Venue> sortVenues(String sortBy) {
        return venueRepository.findAll(Sort.by(sortBy).ascending());
    }
    // //jpa 
    // public List<Venue> getBylocation(String location)
    // {
    //     return venueRepository.findBylocation(location);
    // }
    // //JPQL
    // public List<Venue> getByname(String name)
    // {
    //     return venueRepository.findByname(name);
    // }
    // // JPA: Find venues by location
    // public List<Venue> findVenuesByLocationJPA(String location) {
    //     return venueRepository.findByLocation(location);
    // }

    // // JPQL: Find venues by name
    // public List<Venue> findVenuesByNameJPQL(String name) {
    //     return venueRepository.findByName(name);
    // }
    // Get venue by name using JPQL
     // Get venue by name using JPQL
     @GetMapping("/findByName/{name}")
     public static List<Venue> getByName(@PathVariable String name) {
              return VenueService.getByName(name); // Use instance
     }
 
     // Get venue by location using JPA
     @GetMapping("/findByLocation/{location}")
     public static List<Venue> getByLocation(@PathVariable String location) {
              return VenueService.getByLocation(location); // Use instance
     }

    }

