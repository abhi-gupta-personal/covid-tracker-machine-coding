package com.abhishek.covidproj.controllers;

import com.abhishek.covidproj.models.*;
import com.abhishek.covidproj.repository.UserRepository;
import com.abhishek.covidproj.service.ZoneInfoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ZoneInfoController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ZoneInfoInterface zoneInfoInterface;

    @RequestMapping(value = "/getZoneInfo", method = RequestMethod.GET)
    public ZoneInfo getZoneInfo(@RequestBody ZoneInfoRequest zoneInfoRequest){
        return zoneInfoInterface.getZoneInfo(zoneInfoRequest);
    }
}
