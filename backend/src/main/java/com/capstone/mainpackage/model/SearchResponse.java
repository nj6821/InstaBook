package com.capstone.mainpackage.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {
    private UUID userID;
    private String firstName;
    private String lastName;
    private String email;
}
