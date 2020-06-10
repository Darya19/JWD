package com.epam.day1.service;

import com.epam.day1.entity.Day;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
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
    private final String REGEX ="\\d+";

    public TimeService() {
        this.parser = new NumberParser();
        this.validator = new TimeValidator();
        this.timeParser = new TimeParser();
    }

    public Response<Integer> checkMonth(String date) {
        Integer month;
        if (date.matches(REGEX)) {
            try {
                month = parser.parseToInt(date);
                return validator.validateMonth(month) ?
                        ResponseHelper.makeOkResponse(month) :
                        ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
            } catch (CustomException e) {
                return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
            }
        } else {
            try {
                month = timeParser.parseMonthNameToInt(date);
                return ResponseHelper.makeOkResponse(month);
            } catch (CustomException e) {
                return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
            }
        }
    }

    public Response<Integer> checkYear(String date) {
        int year;
        try {
            year = parser.parseToInt(date);
            return validator.validateYear(year) ?
                    ResponseHelper.makeOkResponse(year) :
                    ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
        } catch (CustomException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
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
                    ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
        } catch (CustomException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
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
