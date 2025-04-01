package com.example.demo.Service;

import com.example.demo.Entity.Event;
import com.example.demo.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Create a new event
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    // Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Update event details
    public Event updateEvent(Long id, Event eventDetails) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();
            existingEvent.setEventName(eventDetails.getEventName());
            existingEvent.setLocation(eventDetails.getLocation());
            existingEvent.setDate(eventDetails.getDate());
            existingEvent.setTime(eventDetails.getTime());
            existingEvent.setAvailableSeats(eventDetails.getAvailableSeats());
            return eventRepository.save(existingEvent);
        } else {
            throw new RuntimeException("Event not found with ID: " + id);
        }
    }

    // Delete event by ID
    public String deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return "Event deleted successfully!";
        } else {
            throw new RuntimeException("Event not found with ID: " + id);
        }
    }

    // Get paginated events
    public Page<Event> getPageEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return eventRepository.findAll(pageable);
    }

    // Get sorted events by a specific field
    public List<Event> sortEvents(String sortBy) {
        return eventRepository.findAll(Sort.by(sortBy).ascending());
    }
     // Find events by name using JPA
     public List<Event> getByEventName(String eventName) {
        return eventRepository.findByEventName(eventName);
    }

    // Find events by location using JPQL
    public List<Event> getByLocation(String location) {
        return eventRepository.findByLocation(location);
    }
}