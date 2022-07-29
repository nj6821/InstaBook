package com.capstone.mainpackage.controller;

import com.capstone.mainpackage.model.LoginRequest;
import com.capstone.mainpackage.model.LoginResponse;
import com.capstone.mainpackage.model.User;
import com.capstone.mainpackage.repository.LogInRepository;
import com.capstone.mainpackage.repository.UserRepository;
import com.capstone.mainpackage.service.LogInService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/instabook/loginService")
public class LogInController {
    @Autowired
    LogInRepository logInRepository;
    @Autowired
    LogInService logInService;
    @PostMapping("/login")
    public LoginResponse save(@RequestBody LoginRequest loginRequest){
        return logInService.authenticate(loginRequest);
    };
    @PostMapping("/logout/{userID}")
    public LoginResponse logOut(@PathVariable UUID userID){
        return logInService.logOut(userID);
    };
}
