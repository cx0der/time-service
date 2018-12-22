package com.moveableapps.timeservice;

public class InvalidTimeStampException extends RuntimeException {

    public InvalidTimeStampException(String timeStamp) {
        super("Invalid timestamp " + timeStamp);
    }
}
