package com.moveableapps.timeservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TimeServiceAdviser {
    @ResponseBody
    @ExceptionHandler(InvalidTimeStampException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String invalidTimeStampHandler(InvalidTimeStampException ex) {
        return ex.getMessage();
    }
}
