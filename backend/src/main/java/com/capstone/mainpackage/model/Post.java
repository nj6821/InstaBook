package com.capstone.mainpackage.model;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "post")
public class Post {
    @Id
    private UUID postID;
    private UUID postUserID;
    private String postTitle;
    private String postContent;
    private Date postDate;
    private String postImageURL;
    private ArrayList<UUID> postLikesUserID;
    private ArrayList<UUID> postCommentID;

}