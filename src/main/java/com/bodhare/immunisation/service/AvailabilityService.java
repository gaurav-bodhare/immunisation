package com.bodhare.immunisation.service;

import com.bodhare.immunisation.dto.SessionDto;
import com.bodhare.immunisation.dto.SubscriptionDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AvailabilityService {

    private SessionService sessionService;

    public AvailabilityService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    protected List<SessionDto> getAvailableSessionsForSubscription(SubscriptionDto subscriptionDto) {
        List<SessionDto> sessionDtos = new ArrayList<>();
        Integer pinCode = subscriptionDto.getPinCode();
        Integer districtId = subscriptionDto.getDistrictId();
        LocalDate localDate = LocalDate.now();
        if (pinCode != null) {
            for (int i = 0; i < 11; i++) {
                sessionDtos.addAll(sessionService.getSessionsByPinCode(pinCode, localDate));
                localDate = localDate.plusDays(7L);
            }
        } else if (districtId != null) {
            for (int i = 0; i < 11; i++) {
                sessionDtos.addAll(sessionService.getSessionsByDistrict(districtId, localDate));
                localDate = localDate.plusDays(7L);
            }
        }
        return sessionDtos;
    }
}
