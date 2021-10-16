package com.abhishek.covidproj.servicesImpl;


import com.abhishek.covidproj.models.CovidReport;
import com.abhishek.covidproj.service.CovidReportInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CovidReportImpl implements CovidReportInterface {


    @Override
    public ResponseEntity<Void> covidResult(CovidReport covidReport) {


        return null;

    }
}
