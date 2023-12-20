package com.user.service.userservice.repository;
import com.user.service.userservice.entities.UserInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends MongoRepository<UserInformation, String> {

    Boolean  existsByEmail(String email);

}

