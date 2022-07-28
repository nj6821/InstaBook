package com.capstone.mainpackage.repository;

import com.capstone.mainpackage.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface PostRepository extends MongoRepository<Post, UUID> {
    ArrayList<Post> findAll();
    Post findBypostID(UUID postID);

    Post deleteBypostID(UUID postID);
}
