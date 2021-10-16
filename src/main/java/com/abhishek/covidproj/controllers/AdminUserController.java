package com.abhishek.covidproj.controllers;


import com.abhishek.covidproj.models.AdminUser;
import com.abhishek.covidproj.models.CovidReport;
import com.abhishek.covidproj.service.AdminUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AdminUserController {

    @Autowired
    AdminUserInterface adminUserService;

    @PostMapping(value = "/registerAdminUser")
    public Map<String, String> createUser(@RequestBody AdminUser adminUser){

        return adminUserService.createAdminUser(adminUser);
    }

    @PostMapping(value = "/updateCovidResult")
    public Map<String, Boolean> updateCovidResult(@RequestBody CovidReport covidReport){

        return adminUserService.updateCovidResult(covidReport);
    }
}


//extensibility -

//prior experience -

//

//scheduler - cronjob - items with capacities in stores - and those stores have capacities or not - activeAtp

