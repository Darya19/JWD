package com.epam.shcherbina.service;

import com.epam.shcherbina.entity.Day;
import com.epam.shcherbina.entity.ResultResponse;
import com.epam.shcherbina.entity.Status;
import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.parser.TimeParser;
import com.epam.shcherbina.validator.TimeValidator;

import java.time.LocalDate;

public class TimeService {

    private  final int SECONDS_IN_MINUTE = 60;
    private  final int SECONDS_IN_HOUR = 3600;

    public ResultResponse<Integer> getMonth(String date){
        NumberParser parser = new NumberParser();
        TimeValidator validator = new TimeValidator();
        TimeParser timeParser = new TimeParser();
        Integer month;
        if (date.contains("^[1-9]$")) {
         try {
             month = parser.parseToInt(date);
                     if(validator.validateMonth(month)){
                         return new ResultResponse<Integer>(Status.OK, "none", month);
                     }
                     else return  new ResultResponse<>(Status.ERROR, "Invalid number",null);
         } catch (InvalidNumberException  e){
             return new ResultResponse<>(Status.ERROR, "Invalid number", null);
         }
        } else {
             month = timeParser.parseMonthToInt(date).getResult();
            if(month != null){
            return new ResultResponse<>(Status.OK, "none", month);}
            else {return new ResultResponse<>(Status.ERROR, "Invalid number", null);
            }
        }
    }

    public ResultResponse<Integer> getYear(String date) {
        NumberParser parser = new NumberParser();
        TimeValidator validator = new TimeValidator();
        try {
            int year = parser.parseToInt(date);
            if (validator.validateYear(year)) {
                return new ResultResponse<Integer>(Status.OK, "none", year);
            } else return new ResultResponse<>(Status.ERROR, "Invalid number", null);
        } catch (InvalidNumberException e) {
            return new ResultResponse<>(Status.ERROR, "Invalid number", null);
        }
    }

    public ResultResponse<Integer> getNumberOfDays(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int numberOfDays = date.lengthOfMonth();
        return new ResultResponse<Integer> (Status.OK, "none", numberOfDays);
    }

    public ResultResponse<Integer> getNumberOfSeconds(String value) {
        NumberParser parser = new NumberParser();
        TimeValidator validator = new TimeValidator();
        int numberOfSeconds;
        try {
            numberOfSeconds = parser.parseToInt(value);
            if (validator.validateNumberOfSeconds(numberOfSeconds)) {
                return new ResultResponse<Integer>(Status.OK, "none", numberOfSeconds);
            } else {
                return new ResultResponse<Integer>(Status.ERROR, "Invalid number", null);
            }
        } catch (InvalidNumberException e) {
            return new ResultResponse<Integer>(Status.ERROR, "Invalid number", null);
        }
    }

    public ResultResponse<Day> calculateNumberOfHoursMinutesSeconds(int value) {
        Day day = new Day();
        day.setHour(value / SECONDS_IN_HOUR);
        day.setMinute(value % SECONDS_IN_HOUR / SECONDS_IN_MINUTE);
        day.setSecond(value % SECONDS_IN_HOUR % SECONDS_IN_MINUTE);
        return new ResultResponse<Day>(Status.OK, "none",day);
    }
}
