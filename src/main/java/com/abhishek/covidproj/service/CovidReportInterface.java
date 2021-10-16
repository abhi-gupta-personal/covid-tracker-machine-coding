package com.abhishek.covidproj.service;


import com.abhishek.covidproj.models.CovidReport;
import org.springframework.http.ResponseEntity;

public interface CovidReportInterface {
    public ResponseEntity<Void> covidResult(CovidReport covidReport);
}
