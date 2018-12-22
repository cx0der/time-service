package com.moveableapps.timeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

@RestController
public class TimeServiceController {

    @GetMapping(value = "/timestamp/{timestamp}")
    public TimeStamp convertToHumanTime(@PathVariable String timestamp) {
        long timeInMills;
        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        inputFormat.setTimeZone(utcTimeZone);

        try {
            timeInMills = Long.parseLong(timestamp);
        } catch (NumberFormatException nfe) {
            // might me a date string, try parsing that
            try {
                timeInMills = inputFormat.parse(timestamp).getTime();
            } catch (ParseException e) {
                throw new InvalidTimeStampException(timestamp);
            }
        }

        Calendar calendar = Calendar.getInstance(utcTimeZone);
        calendar.setTimeInMillis(timeInMills);
        SimpleDateFormat outputFormat = new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        outputFormat.setTimeZone(utcTimeZone);
        return new TimeStamp(outputFormat.format(calendar.getTime()), timeInMills);
    }
}
