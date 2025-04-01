package com.example.demo.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    //JPA
    public List<User> findByEmail(String email);

    //JPQL
    @Query("SELECT e from User e where e.username=:username")
    List<User> findByUsername(@Param("username")String username);
}
