package com.jeevankumar.spring_boot_validations.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ErrorResponse {
    private String title;
    private String message;
    private Map<String,String> details;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timeStamp;

    public ErrorResponse(String title, String message, Map details) {
        this.title = title;
        this.message = message;
        this.details = new HashMap<>();
        this.timeStamp = LocalDateTime.now();
    }

    public ErrorResponse(String title, String message) {
        this(title, message, null);
    }

    public ErrorResponse(String title) {
        this(title, null);
    }


}
