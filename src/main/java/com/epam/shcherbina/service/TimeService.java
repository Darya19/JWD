package com.epam.shcherbina.service;

import com.epam.shcherbina.entity.Day;
import com.epam.shcherbina.entity.Response;
import com.epam.shcherbina.entity.Status;
import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.parser.TimeParser;
import com.epam.shcherbina.validator.TimeValidator;

import java.time.LocalDate;

public class TimeService {

    private  final int SECONDS_IN_MINUTE = 60;
    private  final int SECONDS_IN_HOUR = 3600;

    public Response<Integer> getMonth(String date){
        NumberParser parser = new NumberParser();
        TimeValidator validator = new TimeValidator();
        TimeParser timeParser = new TimeParser();
        Integer month;
        if (date.contains("^[1-9]$")) {
         try {
             month = parser.parseToInt(date);
                     if(validator.validateMonth(month)){
                         return new Response<Integer>(Status.OK, "none", month);
                     }
                     else return  new Response<>(Status.ERROR, "Invalid number",null);
         } catch (InvalidNumberException  e){
             return new Response<>(Status.ERROR, "Invalid number", null);
         }
        } else {
             month = timeParser.parseMonthToInt(date).getResult();
            if(month != null){
            return new Response<>(Status.OK, "none", month);}
            else {return new Response<>(Status.ERROR, "Invalid number", null);
            }
        }
    }

    public Response<Integer> getYear(String date) {
        NumberParser parser = new NumberParser();
        TimeValidator validator = new TimeValidator();
        try {
            int year = parser.parseToInt(date);
            if (validator.validateYear(year)) {
                return new Response<Integer>(Status.OK, "none", year);
            } else return new Response<>(Status.ERROR, "Invalid number", null);
        } catch (InvalidNumberException e) {
            return new Response<>(Status.ERROR, "Invalid number", null);
        }
    }

    public Response<Integer> getNumberOfDays(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int numberOfDays = date.lengthOfMonth();
        return new Response<Integer>(Status.OK, "none", numberOfDays);
    }

    public Response<Integer> getNumberOfSeconds(String value) {
        NumberParser parser = new NumberParser();
        TimeValidator validator = new TimeValidator();
        int numberOfSeconds;
        try {
            numberOfSeconds = parser.parseToInt(value);
            if (validator.validateNumberOfSeconds(numberOfSeconds)) {
                return new Response<Integer>(Status.OK, "none", numberOfSeconds);
            } else {
                return new Response<Integer>(Status.ERROR, "Invalid number", null);
            }
        } catch (InvalidNumberException e) {
            return new Response<Integer>(Status.ERROR, "Invalid number", null);
        }
    }

    public Response<Day> calculateNumberOfHoursMinutesSeconds(int value) {
        Day day = new Day();
        day.setHour(value / SECONDS_IN_HOUR);
        day.setMinute(value % SECONDS_IN_HOUR / SECONDS_IN_MINUTE);
        day.setSecond(value % SECONDS_IN_HOUR % SECONDS_IN_MINUTE);
        return new Response<Day>(Status.OK, "none",day);
    }
}
