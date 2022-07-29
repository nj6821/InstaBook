package com.capstone.mainpackage.controller;

import com.capstone.mainpackage.model.Comment;
import com.capstone.mainpackage.model.LikeRequest;
import com.capstone.mainpackage.model.LikeResponse;
import com.capstone.mainpackage.service.CommentService;
import com.capstone.mainpackage.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/instabook/likeService")
public class LikeController {
    @Autowired
    LikeService likeService;

    @PostMapping("/addlike")
    public LikeResponse addlikeOnPost(@RequestBody LikeRequest likeRequest) {

        return likeService.addlikeOnPost(likeRequest);
    }

    @GetMapping("/getlikersname/{postID}")
    public ArrayList<String> getLikersNameOnPost(@PathVariable("postID") UUID postID){
        return likeService.getLikesOnPost(postID);

    }

    @GetMapping("/countlikes/{postID}")
    public int countLikesOnPost(@PathVariable("postID") UUID postID){
        return likeService.countLikesOnPost(postID);

    }
}
