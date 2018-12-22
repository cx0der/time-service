package com.moveableapps.timeservice;

public class TimeStamp {
    private final String utc;
    private final Long unixTime;

    TimeStamp(String dateString, long unixTime) {
        this.utc = dateString;
        this.unixTime = unixTime;
    }

    public String getUtc() {
        return this.utc;
    }

    public Long getUnixTime() {
        return unixTime;
    }
}
