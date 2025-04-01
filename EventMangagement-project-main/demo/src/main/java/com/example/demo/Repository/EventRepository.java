package com.example.demo.Repository;

import com.example.demo.Entity.Event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
    //JPA
    public List<Event> findByEventName(String eventName);
//JPQL
 @Query("SELECT e from Event e where e.location=:location")
    List<Event> findByLocation(@Param("location")String location);
}
