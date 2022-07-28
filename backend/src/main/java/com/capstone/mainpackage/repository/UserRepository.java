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
//    User save(User user);
    ArrayList<User> findAll();
//    ArrayList<User> findByName(String firstName);

    ArrayList<User> findByFirstName(String firstName);
    ArrayList<User> findByLastName(String lastName);
}
