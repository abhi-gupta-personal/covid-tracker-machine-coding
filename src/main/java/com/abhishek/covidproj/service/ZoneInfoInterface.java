package com.abhishek.covidproj.service;

import com.abhishek.covidproj.models.ZoneInfo;
import com.abhishek.covidproj.models.ZoneInfoRequest;

public interface ZoneInfoInterface {
    public ZoneInfo getZoneInfo(ZoneInfoRequest zoneInfoRequest);
}
