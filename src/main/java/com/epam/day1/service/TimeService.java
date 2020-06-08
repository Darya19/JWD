package com.epam.day1.service;

import com.epam.day1.entity.Day;
import com.epam.day1.entity.Response;
import com.epam.day1.exception.CustomException;
import com.epam.day1.parser.NumberParser;
import com.epam.day1.parser.TimeParser;
import com.epam.day1.validator.TimeValidator;

import java.time.LocalDate;

public class TimeService {

    private NumberParser parser;
    private TimeValidator validator;
    private TimeParser timeParser;
    private final int SECONDS_IN_MINUTE = 60;
    private final int SECONDS_IN_HOUR = 3600;

    public TimeService() {
        this.parser = new NumberParser();
        this.validator = new TimeValidator();
        this.timeParser = new TimeParser();
    }

    public Response<Integer> checkMonth(String date) {
        Integer month;
        if (date.matches("^[1-9]$")) {
            try {
                month = parser.parseToInt(date);
                return validator.validateMonth(month) ?
                        ResponseHelper.makeOkResponse(month) :
                        ResponseHelper.makeErrorResponse();
            } catch (CustomException e) {
                return ResponseHelper.makeErrorResponse();
            }
        } else {
            try {
                month = timeParser.parseMonthNameToInt(date).getResult();
                return month != null ?
                        ResponseHelper.makeOkResponse(month) :
                        ResponseHelper.makeErrorResponse();
            } catch (CustomException e) {
                return ResponseHelper.makeErrorResponse();
            }
        }
    }

    public Response<Integer> checkYear(String date) {
        try {
            int year = parser.parseToInt(date);
            return validator.validateYear(year) ?
                    ResponseHelper.makeOkResponse(year) :
                    ResponseHelper.makeErrorResponse();
        } catch (CustomException e) {
            return ResponseHelper.makeErrorResponse();
        }
    }

    public Response<Integer> getNumberOfDays(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int numberOfDays = date.lengthOfMonth();
        return ResponseHelper.makeOkResponse(numberOfDays);
    }

    public Response<Integer> checkNumberOfSeconds(String value) {
        int numberOfSeconds;
        try {
            numberOfSeconds = parser.parseToInt(value);
            return validator.validateNumberOfSeconds(numberOfSeconds) ?
                    ResponseHelper.makeOkResponse(numberOfSeconds) :
                    ResponseHelper.makeErrorResponse();
        } catch (CustomException e) {
            return ResponseHelper.makeErrorResponse();
        }
    }

    public Response<Day> calculateNumberOfHoursMinutesSeconds(int value) {
        Day day = new Day();
        day.setHour(value / SECONDS_IN_HOUR);
        day.setMinute(value % SECONDS_IN_HOUR / SECONDS_IN_MINUTE);
        day.setSecond(value % SECONDS_IN_HOUR % SECONDS_IN_MINUTE);
        return ResponseHelper.makeOkResponse(day);
    }
}
