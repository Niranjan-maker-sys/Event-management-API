package com.example.demo.Repository;

import com.example.demo.Entity.Venue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    //JPA
    public List<Venue> findByLocation(String location);

    @Query("SELECT e from Venue e where e.name=:name")
    List<Venue> findByName(@Param("name")String name);

}
