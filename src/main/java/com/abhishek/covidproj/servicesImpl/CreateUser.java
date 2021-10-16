package com.abhishek.covidproj.servicesImpl;


import com.abhishek.covidproj.models.SelfAssesment;
import com.abhishek.covidproj.models.Symptoms;
import com.abhishek.covidproj.models.User;
import com.abhishek.covidproj.repository.UserRepository;
import com.abhishek.covidproj.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
public class CreateUser implements UserInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public Map<String, String> createUser(User user) {

        User createdUser = userRepository.save(user);
        System.out.println("Created User Id : " +createdUser.getId());
        Map<String, String> response = new HashMap<>();
        response.put("userId", String.valueOf(createdUser.getId()));
        return response;

    }

    @Override
    @Transactional
    public Map<String, Integer> selfAssessment(SelfAssesment assesment){
        Map<String, Integer> response = new HashMap<>();
        List<Symptoms> symptomsList = new ArrayList<>();
        if (assesment.getSymptomsList() != null) {
            symptomsList = assesment.getSymptomsList();
        }
        boolean travelHistory = assesment.isTravelHistory();
        boolean contactWithCovid = assesment.isContactWithCovidPatient();

        if (symptomsList.size() == 0 && !travelHistory && !contactWithCovid)
            response.put("riskPercentage" , 5);
        if (symptomsList.size() == 1 && (travelHistory || contactWithCovid))
            response.put("riskPercentage" , 50);
        if (symptomsList.size() == 2 && (travelHistory || contactWithCovid))
            response.put("riskPercentage" , 75);
        if (symptomsList.size() > 2 && (travelHistory || contactWithCovid))
            response.put("riskPercentage" , 95);

        return response;
    }
}
