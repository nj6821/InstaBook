package com.capstone.mainpackage.repository;

import com.capstone.mainpackage.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
//    User save(User user);
    ArrayList<User> findAll();
    ArrayList<User> findByName(String firstName);
}
