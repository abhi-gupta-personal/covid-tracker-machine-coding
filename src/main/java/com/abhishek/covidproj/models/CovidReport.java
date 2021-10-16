package com.abhishek.covidproj.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CovidReport {
    public String userId;
    public String adminId;
    private String result;
}
