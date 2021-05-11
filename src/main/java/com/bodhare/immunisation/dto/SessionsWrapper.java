package com.bodhare.immunisation.dto;

import java.util.List;

public class SessionsWrapper {

    List<SessionDto> sessionDtos;

    public List<SessionDto> getSessionDtos() {
        return sessionDtos;
    }

    public void setSessionDtos(List<SessionDto> sessionDtos) {
        this.sessionDtos = sessionDtos;
    }
}
