package com.capstone.mainpackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeResponse {
    private boolean likeStatus;
    private String likeMessage;
}
