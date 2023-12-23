package com.user.service.userservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.service.userservice.entities.UserCredentials;

@Repository
public interface CredentialsRepository extends JpaRepository<UserCredentials, Integer> {
    Boolean existsByEmail(String email);
    Boolean existsByUserName(String username);

    @Query(
        value = "SELECT u.hash_password FROM user_credentials u WHERE u.email = :email", 
        nativeQuery = true)
    String getHashPassword(@Param("email") String email);
}
