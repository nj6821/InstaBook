package com.capstone.mainpackage.service;

import com.capstone.mainpackage.model.LoginRequest;
import com.capstone.mainpackage.model.LoginResponse;
import com.capstone.mainpackage.model.User;
import com.capstone.mainpackage.repository.LogInRepository;
import com.capstone.mainpackage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LogInService {
    @Autowired
    LogInRepository loginRepository;
    @Autowired
    UserRepository userRepository;
    @Value("${pepper}")
    String pepper;
    public LoginResponse authenticate(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail());
        LoginResponse loginResponse= new LoginResponse();
        if(user == null){
            loginResponse.setLoginStatus(false);
            loginResponse.setMessage("User not found! Invalid email");
        }else{
            String hashedPassword = BCrypt.hashpw(loginRequest.getPassword() + pepper, user.getSalt());
            if(hashedPassword.equals(user.getPassword())){

                loginResponse.setLoginStatus(true);
                loginResponse.setMessage("login successful");



            }else{
                loginResponse.setLoginStatus(false);
                loginResponse.setMessage("Invalid password");
            }
            loginResponse.setUserID(user.getUserID());
            loginResponse.setEmail(user.getEmail());
            loginRepository.save(loginResponse );
        }


        return loginResponse;
    }
    public LoginResponse logOut(UUID userID){
        LoginResponse loginResponseFromDB = loginRepository.findByUserID(userID);
        User user = userRepository.findByUserID(userID);
        LoginResponse loginResponse = new LoginResponse();
        if(loginResponseFromDB == null ) {
            loginResponse.setLoginStatus(false);;
            loginResponse.setMessage("email id not registered.");
        }
        else if(loginResponseFromDB.isLoginStatus()){
            loginResponseFromDB.setLoginStatus(false);
            loginResponse.setLoginStatus(false);;

            loginResponse.setUserID(userID);
            loginResponse.setEmail(user.getEmail());
            loginResponse.setMessage("logged out successfully");
            loginRepository.save(loginResponseFromDB);
        }
        else {
            loginResponse.setUserID(userID);
            loginResponse.setEmail(user.getEmail());
            loginResponse.setMessage("you are not logged in");
        }
        return loginResponse;
    }
}
