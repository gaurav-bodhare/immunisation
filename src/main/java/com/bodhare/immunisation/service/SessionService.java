package com.bodhare.immunisation.service;

import com.bodhare.immunisation.dto.SessionDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SessionService {

    protected List<SessionDto> getSessionsByPinCode(int pinCode, LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return null;
    }

    protected List<SessionDto> getSessionsByDistrict(int district, LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return null;
    }
}
