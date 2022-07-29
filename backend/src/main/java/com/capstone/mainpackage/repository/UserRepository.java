package com.capstone.mainpackage.repository;

import com.capstone.mainpackage.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
    User findByUserID(UUID userID);
    User findByEmail(String email);
    ArrayList<User>findAll();
    ArrayList<User> findByFirstNameContainingIgnoreCase(String firstName);
    ArrayList<User> findByLastNameContainingIgnoreCase(String firstName);

}
