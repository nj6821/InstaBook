package com.capstone.mainpackage.service;

import com.capstone.mainpackage.model.*;
import com.capstone.mainpackage.repository.CommentRepository;
import com.capstone.mainpackage.repository.LogInRepository;
import com.capstone.mainpackage.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;
    public Comment addCommentOnPost(Comment comment){
        comment.setCommentID(UUID.randomUUID());
        Date date=new Date();
        comment.setCommentDate(date);
        Post post = postRepository.findBypostID(comment.getPostID());
        ArrayList<UUID>postCommentIDs = post.getPostCommentID();
        postCommentIDs.add(comment.getCommentID());
        postRepository.save(post);
        commentRepository.save(comment);
        return comment;
    }


    public ArrayList<Comment> getCommentsOnPost(UUID postID) {
        ArrayList<Comment> comments;
        comments = commentRepository.findAllByPostID(postID);
        return comments;
    }
}
