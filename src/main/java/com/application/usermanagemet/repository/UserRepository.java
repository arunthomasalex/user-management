package com.application.usermanagemet.repository;

import java.util.Optional;

import com.application.usermanagemet.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    
    Boolean existsByUsername(String username);
}