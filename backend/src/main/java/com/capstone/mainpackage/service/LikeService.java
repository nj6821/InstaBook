package com.capstone.mainpackage.service;

import com.capstone.mainpackage.model.*;
import com.capstone.mainpackage.repository.PostRepository;
import com.capstone.mainpackage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class LikeService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    public LikeResponse addlikeOnPost(LikeRequest likeRequest) {
        LikeResponse likeResponse = new LikeResponse();
        if(likeRequest.getLikerUserID() == null){
            likeResponse.setLikeStatus(false);
            likeResponse.setLikeMessage("Invalid user");
        }
        else if(likeRequest.getPostID() == null){
            likeResponse.setLikeStatus(false);
            likeResponse.setLikeMessage("Post does not exist");
        }
        else{
            Post post = postRepository.findBypostID(likeRequest.getPostID());
            ArrayList<UUID>postLikesUserID = post.getPostLikesUserID();
            postLikesUserID.add(likeRequest.getLikerUserID());
            postRepository.save(post);
            likeResponse.setLikeStatus(true);
            likeResponse.setLikeMessage("like added");
        }


        return likeResponse;
    }

    public ArrayList<String> getLikesOnPost(UUID postID) {
        Post post = postRepository.findBypostID(postID);
        ArrayList<UUID>postLikesUserID = post.getPostLikesUserID();
        ArrayList<String>postLikersName = new ArrayList<>();
        ArrayList<User> userList = userRepository.findAll();
        HashMap<UUID, String> hm = new HashMap<>();
        for(User user: userList){
            hm.put(user.getUserID(),user.getFirstName() + " " + user.getLastName());
        }
        for(UUID userID: postLikesUserID  ){
            postLikersName.add(hm.get(userID));
        }
        return  postLikersName;
    }

    public int countLikesOnPost(UUID postID) {
        int likes = 0;
        Post post = postRepository.findBypostID(postID);
        ArrayList<UUID>postLikesUserID = post.getPostLikesUserID();
        likes = postLikesUserID.size();
        return likes;
    }
}
