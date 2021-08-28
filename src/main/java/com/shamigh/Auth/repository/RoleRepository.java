package com.shamigh.Auth.repository;

import com.shamigh.Auth.models.ERole;
import com.shamigh.Auth.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
