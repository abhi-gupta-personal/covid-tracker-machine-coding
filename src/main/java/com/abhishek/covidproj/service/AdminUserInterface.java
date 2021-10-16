package com.abhishek.covidproj.service;


import com.abhishek.covidproj.models.AdminUser;
import com.abhishek.covidproj.models.CovidReport;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface AdminUserInterface {
    public Map<String, String> createAdminUser(AdminUser adminUser);
    public Map<String, Boolean> updateCovidResult(CovidReport covidReport);
}
