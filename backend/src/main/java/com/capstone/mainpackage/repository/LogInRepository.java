package com.capstone.mainpackage.repository;

import com.capstone.mainpackage.model.LoginResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface LogInRepository extends MongoRepository<LoginResponse, UUID> {
    LoginResponse findByUserID(UUID userID);
    LoginResponse findByEmail(String email);
}
