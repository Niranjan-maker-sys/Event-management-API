package com.example.demo.Service;

import com.example.demo.Entity.Organizer;
import com.example.demo.Repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepo;

    // Add a new organizer
    public Organizer addOrganizer(Organizer organizer) {
        return organizerRepo.save(organizer);
    }

    // Get all organizers
    public List<Organizer> getAllOrganizers() {
        return organizerRepo.findAll();
    }

    // Update organizer details
    public Organizer updateOrganizer(Long id, Organizer organizerDetails) {
        Optional<Organizer> optionalOrganizer = organizerRepo.findById(id);

        if (optionalOrganizer.isPresent()) {
            Organizer existingOrganizer = optionalOrganizer.get();
            existingOrganizer.setName(organizerDetails.getName());
            existingOrganizer.setrole(organizerDetails.getrole());
            existingOrganizer.setEvent(organizerDetails.getEvents());
            return organizerRepo.save(existingOrganizer);
        } else {
            throw new RuntimeException("Organizer not found with ID" + id);
        }
    }

    // Delete organizer by ID
    public String deleteOrganizer(Long id) {
        if (organizerRepo.existsById(id)) {
            organizerRepo.deleteById(id);
            return "Organizer deleted successfully!";
        } else {
            throw new RuntimeException("Organizer not found with ID: " + id);
        }
    }
    

    // Get paginated organizers
    public Page<Organizer> getPageOrganizers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return organizerRepo.findAll(pageable);
    }

    // Get sorted organizers by a specific field
    public List<Organizer> sortOrganizers(String sortBy) {
        return organizerRepo.findAll(Sort.by(sortBy).ascending());
    }
    public List<Organizer>getByname(String name)
    {
        return organizerRepo.findByName(name);
    }

    // //jpql
    // public List<Organizer> getByrole(String role)
    // {
    //     return organizerRepo.findByrole(role);
    // }
    // Get organizers by name using JPA
    public List<Organizer> findOrganizersByNameJPA(String name) {
        return organizerRepo.findByName(name);
    }

    // Get organizers by role using JPQL
    public List<Organizer> findOrganizersByRoleJPQL(String role) {
        return organizerRepo.findByrole(role);
    }
}
