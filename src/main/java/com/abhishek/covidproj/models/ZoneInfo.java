package com.abhishek.covidproj.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ZoneInfo {
    private Integer numCases;
    private ZoneType zoneType;
}
