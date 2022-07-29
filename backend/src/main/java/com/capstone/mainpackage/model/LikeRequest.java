package com.capstone.mainpackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeRequest {
    private UUID postID;
    private UUID likerUserID;
}
