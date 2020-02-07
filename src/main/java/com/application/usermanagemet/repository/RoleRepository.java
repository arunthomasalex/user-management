package com.application.usermanagemet.repository;

import java.util.Optional;

import com.application.usermanagemet.domain.Role;
import com.application.usermanagemet.domain.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
    
}