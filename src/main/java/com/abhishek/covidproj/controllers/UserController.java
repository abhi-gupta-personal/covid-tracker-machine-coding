package com.abhishek.covidproj.controllers;

import com.abhishek.covidproj.models.SelfAssesment;
import com.abhishek.covidproj.models.User;
import com.abhishek.covidproj.repository.UserRepository;
import com.abhishek.covidproj.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    UserInterface userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public Map<String, String> createUser(@RequestBody User user){

        return userService.createUser(user);
    }

    @RequestMapping(value = "/selfassessment", method = RequestMethod.GET)
    public Map<String, Integer> getAssessment(@RequestBody SelfAssesment assesment){
        return userService.selfAssessment(assesment);
    }

    @GetMapping(value = "/getUser/{phoneNo}")
    public User getUser(@PathVariable(value="userEmail", required = true) String phoneNo){
        User foundUser = userRepository.findByPhoneNumber(phoneNo);
        return foundUser;
    }

    @GetMapping(value = "/findAllUsers")
    public List<User> getUser(){
        List<User> foundUser = userRepository.findAll();
        return foundUser;
    }
}
