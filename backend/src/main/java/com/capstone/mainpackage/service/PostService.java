package com.capstone.mainpackage.service;

import com.capstone.mainpackage.model.Post;
import com.capstone.mainpackage.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Service
public class PostService{

    @Autowired
    PostRepository postRepository;

    public void savePost(Post post){
        Date date= new Date();
        long time= date.getTime();
        post.setPostID(UUID.randomUUID());
        post.setPostDate(date);
        postRepository.save(post);
    }

    public void updatePost(Post post){
        Post oldpost=postRepository.findBypostID(post.getPostID());
        oldpost.setPostContent(post.getPostContent());
        oldpost.setPostTitle(post.getPostTitle());
        Date date=new Date();
        long time= date.getTime();
        Timestamp dateTime=new Timestamp(time);
        oldpost.setPostDate(dateTime);
        postRepository.save(oldpost);
    }

}
