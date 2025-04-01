package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String eventName;

    private String location;
    private String date;
    private String time;
    private int availableSeats;

    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    @JsonBackReference
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    @JsonBackReference
    private Organizer organizer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    // Default constructor
    public Event() {}

    // Parameterized constructor
    public Event(String eventName, String location, String date, String time, int availableSeats) {
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.time = time;
        this.availableSeats = availableSeats;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

    public Venue getVenue() { return venue; }
    public void setVenue(Venue venue) { this.venue = venue; }

    public Organizer getOrganizer() { return organizer; }
    public void setOrganizer(Organizer organizer) { this.organizer = organizer; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
