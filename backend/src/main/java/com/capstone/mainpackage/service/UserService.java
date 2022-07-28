package com.capstone.mainpackage.service;

import com.capstone.mainpackage.model.LoginRequest;
import com.capstone.mainpackage.model.LoginResponse;
import com.capstone.mainpackage.model.SignUpResponse;
import com.capstone.mainpackage.model.User;
import com.capstone.mainpackage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserService {

    //   // String peper = "qwery@123";
    @Value("${pepper}")
    String pepper;
    @Autowired
    UserRepository userRepository;

    public LoginResponse authenticate(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = new LoginResponse();
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
        }

        return loginResponse;
    }
    public SignUpResponse register(User user){
       // System.out.println(user);
        User currentUser = userRepository.findByEmail(user.getEmail());
        SignUpResponse signUpResponse = new SignUpResponse();
        if(currentUser != null){
            signUpResponse.setSignUpStatus(false);
            signUpResponse.setSignUpMessage("User already exists");
            return signUpResponse;
        }else{
            //setting unique userID
            user.setUserID(UUID.randomUUID());

//            //setting signUPDate
//            Date date=new Date();
//            long time=date.getTime();
//            Timestamp dateTime=new Timestamp(time);
//            user.setSignUpDate(dateTime);

            String salt = BCrypt.gensalt();
            String hashedPassword = BCrypt.hashpw(user.getPassword() + pepper, salt);
            user.setPassword(hashedPassword);
            user.setSalt(salt);
            userRepository.save(user);
            signUpResponse.setSignUpStatus(true);
            signUpResponse.setSignUpMessage("Signup successful");
            return signUpResponse;

        }

    }
    public ArrayList<User> retrieveAll()
    {
        return userRepository.findAll();
    }
    public ArrayList<User> retrieveByName(String firstName)
    {
//        String firstName;
        return userRepository.findByFirstName(firstName);
    }

}
