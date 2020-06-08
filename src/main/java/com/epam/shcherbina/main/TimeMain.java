package com.epam.shcherbina.main;

import com.epam.shcherbina.console.PrintResult;
import com.epam.shcherbina.service.TimeService;

public class TimeMain {

    public static void main(String[] args) {
        TimeService service = new TimeService();
        PrintResult print = new PrintResult();
        int month = service.getMonth("february").getResult();
        int year = service.getYear("2021").getResult();
        int daysOfMonth = service.getNumberOfDays(year, month).getResult();
        print.echoResult(daysOfMonth);

        int seconds = service.getNumberOfSeconds("34789").getResult();
        print.echoResult(service.calculateNumberOfHoursMinutesSeconds(seconds).getResult().toString());
    }
}
