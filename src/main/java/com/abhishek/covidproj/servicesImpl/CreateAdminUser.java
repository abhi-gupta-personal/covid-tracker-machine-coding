package com.abhishek.covidproj.servicesImpl;


import com.abhishek.covidproj.models.AdminUser;
import com.abhishek.covidproj.models.CovidReport;
import com.abhishek.covidproj.models.User;
import com.abhishek.covidproj.repository.AdminUserRepository;
import com.abhishek.covidproj.repository.UserRepository;
import com.abhishek.covidproj.service.AdminUserInterface;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class CreateAdminUser implements AdminUserInterface {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public Map<String, String> createAdminUser(AdminUser adminUser) {

        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        Map<String, String> response = new HashMap<>();
        response.put("adminId", String.valueOf(newAdminUser.getAdminId()));
        return response;
    }

    @Override
    @Transactional
    public Map<String, Boolean> updateCovidResult(CovidReport covidReport){
        Map<String, Boolean> response = new HashMap<>();
        User user = null;
        AdminUser adminUser = null;
        try {
            user  = userRepository.getById(Long.valueOf(covidReport.getUserId()));
            adminUser  = adminUserRepository.getById(Long.valueOf(covidReport.getAdminId()));
        } catch (EntityNotFoundException e){
            throw new EntityNotFoundException("No User or Admin found in the DB");
        }

        if (Objects.nonNull(user) && Objects.nonNull(adminUser)) {
            User updatedUser = User.builder().id(Long.valueOf(covidReport.getUserId()))
                    .result(covidReport.getResult())
                    .name(user.getName())
                    .phoneNumber(user.getPhoneNumber())
                    .pinCode(user.getPinCode()).build();
            userRepository.save(updatedUser);

            response.put("updated", true);

        }
        else {
            response.put("updated", false);

        }

        return response;
    }
}
