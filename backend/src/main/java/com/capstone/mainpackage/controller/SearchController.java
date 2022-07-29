package com.capstone.mainpackage.controller;

import com.capstone.mainpackage.model.SearchRequest;
import com.capstone.mainpackage.model.SearchResponse;
import com.capstone.mainpackage.model.SignUpResponse;
import com.capstone.mainpackage.model.User;
import com.capstone.mainpackage.repository.UserRepository;
import com.capstone.mainpackage.service.SearchService;
import com.capstone.mainpackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/instabook/searchService")
public class SearchController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    SearchService searchService;

    @GetMapping(value="/searchusers", consumes="application/json", produces="application/json")
    public ArrayList<SearchResponse> searchUsers(@RequestBody SearchRequest searchRequest){
        //System.out.println("controller called");
        return searchService.searchUsers(searchRequest.getName());
    }
}
