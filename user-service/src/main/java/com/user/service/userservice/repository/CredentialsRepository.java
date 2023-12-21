package com.user.service.userservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.userservice.entities.UserCredentials;

@Repository
public interface CredentialsRepository extends JpaRepository<UserCredentials, Integer> {
    Boolean existsByEmail(String email);
    Boolean existsByUserName(String username);
}
