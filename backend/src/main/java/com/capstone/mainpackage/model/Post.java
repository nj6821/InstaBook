package com.capstone.mainpackage.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "post")
public class Post {
    @Id
    private UUID postID;
    private UUID postUserID;
    private String postTitle;
    private String postContent;
    private Timestamp postDate;
    private String postImageURL;
    private ArrayList<UUID> postLikesUserID;
    private ArrayList<UUID> postCommentUserID;

}