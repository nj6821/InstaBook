package com.capstone.mainpackage.service;

import com.capstone.mainpackage.model.Comment;
import com.capstone.mainpackage.model.SearchResponse;
import com.capstone.mainpackage.model.User;
import com.capstone.mainpackage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
@Service
public class SearchService {
    @Autowired
    UserRepository userRepository;
    public ArrayList<SearchResponse> searchUsers(String name) {
        ArrayList<User>userContainingFirstName = userRepository.findByFirstNameContainingIgnoreCase(name);
        ArrayList<User>userContainingLastName = userRepository.findByLastNameContainingIgnoreCase(name);
        userContainingFirstName.addAll(userContainingLastName);
        ArrayList<SearchResponse>userDetails = new ArrayList<>();
        for(User user: userContainingFirstName){
            SearchResponse sr = new SearchResponse(user.getUserID(), user.getFirstName(), user.getLastName(), user.getEmail());
            userDetails.add(sr);
        }
        //System.out.println("service called" );
        //System.out.println(userDetails);
        return  userDetails;

    }
}
