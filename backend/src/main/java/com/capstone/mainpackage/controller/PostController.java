package com.capstone.mainpackage.controller;

import com.capstone.mainpackage.model.LoginRequest;
import com.capstone.mainpackage.model.LoginResponse;
import com.capstone.mainpackage.model.Post;
import com.capstone.mainpackage.repository.PostRepository;
import com.capstone.mainpackage.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/instabook/postService")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    @PostMapping(value = "/addpost", consumes = "Application/json")
    public String addPost(@RequestBody Post post){

        postService.savePost(post);
        return "post has been saved successfully";
    }

    @GetMapping("/getpost")
    public ArrayList<Post> getAllPost(){
        ArrayList<Post> postlist=postRepository.findAll();
        postlist.sort((e1,e2) -> e2.getPostDate().compareTo(e1.getPostDate()));
        return postlist;
    }

    @PutMapping(value = "/editpost", consumes = "Application/json")
    public String editPost(@RequestBody Post post)
    {
        postService.updatePost(post);
        return "post has been saved successfully!";
    }

    @DeleteMapping("/deletepost")
    public String deletePost(@RequestBody Post post)
    {
        postRepository.deleteBypostID(post.getPostID());
        return "post deleted successfully";
    }
}
