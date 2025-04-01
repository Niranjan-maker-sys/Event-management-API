package com.example.demo.Repository;

import com.example.demo.Entity.Organizer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrganizerRepository extends JpaRepository<Organizer, Long>{
    //jpa
    public List<Organizer>findByName(String name);

    //jpql
     @Query("SELECT e from Organizer e where e.role=:role")
    List<Organizer> findByrole(@Param("role")String role);
}
