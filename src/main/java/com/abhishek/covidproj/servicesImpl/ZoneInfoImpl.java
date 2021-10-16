package com.abhishek.covidproj.servicesImpl;

import com.abhishek.covidproj.models.*;
import com.abhishek.covidproj.repository.UserRepository;
import com.abhishek.covidproj.service.ZoneInfoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ZoneInfoImpl implements ZoneInfoInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public ZoneInfo getZoneInfo(ZoneInfoRequest zoneInfoRequest) {
        List<User> foundUser = userRepository.findAll();
        List<User> positiveCovidUsersSamePin = foundUser.stream().filter(user -> user.getPinCode().equals(zoneInfoRequest.getPincode()) &&
                Objects.nonNull(user.getResult()) && user.getResult().equalsIgnoreCase(CovidResult.POSITIVE.toString())).collect(Collectors.toList());
        int count = positiveCovidUsersSamePin.size();
        if (count == 0)
            return ZoneInfo.builder().zoneType(ZoneType.GREEN).numCases(count).build();
        else if (count > 0 && count < 5)
            return ZoneInfo.builder().zoneType(ZoneType.ORANGE).numCases(count).build();
        else
            return ZoneInfo.builder().zoneType(ZoneType.RED).numCases(count).build();
    }
}
