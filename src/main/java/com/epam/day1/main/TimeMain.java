package com.epam.day1.main;

import com.epam.day1.console.PrintResult;
import com.epam.day1.service.TimeService;

public class TimeMain {

    public static void main(String[] args) {
        TimeService service = new TimeService();
        PrintResult print = new PrintResult();
        int month = service.checkMonth("4").getResult();
        int year = service.checkYear("2021").getResult();
        int daysOfMonth = service.getNumberOfDays(year, month).getResult();
        print.echoResult(daysOfMonth);

        int seconds = service.checkNumberOfSeconds("34789").getResult();
        print.echoResult(service.calculateNumberOfHoursMinutesSeconds(seconds).getResult().toString());
    }
}
