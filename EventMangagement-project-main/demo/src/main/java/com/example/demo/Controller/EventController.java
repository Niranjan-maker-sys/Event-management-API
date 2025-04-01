package com.example.demo.Controller;

import com.example.demo.Entity.Event;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    
    @Autowired
    private EventService eventService;

    // Create a new event
    @PostMapping("/add")
    public Event createEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    // Get all events
    @GetMapping("/get")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Get events with pagination and sorting
    @GetMapping("/getPaged")
    public List<Event> getEventsPaged(Pageable pageable) {
        return eventService.getAllEvents();
    }

    // Get events by name using JPA
    @GetMapping("/findByName/{eventName}")
    public List<Event> getEventsByName(@PathVariable String eventName) {
        return eventService.getByEventName(eventName);
    }

    // Get events by location using JPQL
    @GetMapping("/findByLocation/{location}")
    public List<Event> getEventsByLocation(@PathVariable String location) {
        return eventService.getByLocation(location);
    }

    // Update an event by ID
    @PutMapping("/update/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    // Delete an event by ID
    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        return eventService.deleteEvent(id);
    }
}
