package com.abhishek.covidproj.models;

import lombok.Data;

import java.util.List;

@Data
public class SelfAssesment {
    private List<Symptoms> symptomsList;
    private boolean travelHistory;
    private boolean contactWithCovidPatient;
    private User id;
}
