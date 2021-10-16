package com.abhishek.covidproj.service;


import com.abhishek.covidproj.models.SelfAssesment;
import com.abhishek.covidproj.models.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserInterface {
    public Map<String, String> createUser(User user);
    public Map<String, Integer> selfAssessment(SelfAssesment assesment);
}
