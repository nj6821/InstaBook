package com.capstone.mainpackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "loginTable")
public class LoginResponse {
    @Id
    private UUID userID;
    private String email;
    private boolean loginStatus;
    private String message;

}
