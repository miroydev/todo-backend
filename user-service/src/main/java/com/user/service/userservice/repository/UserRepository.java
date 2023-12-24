package com.user.service.userservice.repository;
import com.user.service.userservice.entities.UserInformation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<UserInformation, Integer> {
}

