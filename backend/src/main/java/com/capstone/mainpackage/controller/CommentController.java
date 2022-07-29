package com.capstone.mainpackage.controller;

import com.capstone.mainpackage.model.Comment;
import com.capstone.mainpackage.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/instabook/commentService")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/addcomment")
    public Comment commentOnPost(@RequestBody Comment comment) {

        return commentService.addCommentOnPost(comment);
    }

    @GetMapping("/getcomments/{postID}")
    public ArrayList<Comment> getCommentsOnPost(@PathVariable("postID") UUID postID){
        return commentService.getCommentsOnPost(postID);

    }


}
