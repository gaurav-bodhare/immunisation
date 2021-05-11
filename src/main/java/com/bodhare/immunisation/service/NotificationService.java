package com.bodhare.immunisation.service;

import com.bodhare.immunisation.dto.SessionDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NotificationService {

    private final String fileLocation = "/jsonFile.json";

    private ObjectMapper objectMapper;

    private FileWriter fileWriter;

    private MailService mailService;

    NotificationService(MailService mailService) {
        this.mailService = mailService;
        objectMapper = new ObjectMapper();
    }


    protected void sendNotification(String email, List<SessionDto> sessionDtos) {
        String message = prepareMessage(sessionDtos);
        prepareAttachment(sessionDtos);
        mailService.sendEmail(email, "Slot availability", message, true, false, "Slots.json", new File(fileLocation));
    }

    protected String prepareMessage(List<SessionDto> sessionDtos) {
        StringBuilder message = new StringBuilder();
        for (SessionDto sessionDto : sessionDtos) {
            message.append(sessionDto.toString());
            message.append(System.getProperty("line.separator"));
        }
        return message.toString();
    }

    protected void prepareAttachment(List<SessionDto> sessionDtos) {
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(sessionDtos);
        } catch (JsonProcessingException jsonProcessingException) {
            System.out.println(jsonProcessingException.getMessage());
        }
        try {
            fileWriter = new FileWriter(fileLocation);
            fileWriter.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
