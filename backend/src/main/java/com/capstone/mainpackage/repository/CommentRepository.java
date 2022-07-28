package com.capstone.mainpackage.repository;

import com.capstone.mainpackage.model.Comment;
import com.capstone.mainpackage.model.LoginResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface CommentRepository extends MongoRepository<Comment, UUID> {
    ArrayList<Comment> findAllByPostID(UUID postID);
}
