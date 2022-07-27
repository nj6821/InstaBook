package com.capstone.mainpackage.controller;

import com.capstone.mainpackage.model.LoginRequest;
import com.capstone.mainpackage.model.LoginResponse;
import com.capstone.mainpackage.model.SignUpResponse;
import com.capstone.mainpackage.model.User;
import com.capstone.mainpackage.repository.UserRepository;
import com.capstone.mainpackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@Controller
@RequestMapping("/api/userService")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public LoginResponse save(@RequestBody LoginRequest loginRequest){
        return userService.authenticate(loginRequest);
    };

    @PostMapping(value="/signup", consumes="application/json", produces="application/json")
    public SignUpResponse signup(@RequestBody User user){
        SignUpResponse signupResponse = userService.register(user);
        System.out.println(user);
        return signupResponse;
    }
    @GetMapping("/getUsers")
    public ArrayList<User> getAllUsers()
    {
        return userService.retrieveAll();
    }
//    @GetMapping("/getUserByName/{firstName}")
//    public ArrayList<User> getUserByName(@PathVariable("firstName") String firstName)
//    {
//        ArrayList<User> ak=userService.retrieveByName(firstName);
////        System.out.println(ak);
////        return userService.retrieveByName(firstName);
//        return ak;
//    }

}
