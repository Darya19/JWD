package com.epam.day1.service;

import com.epam.day1.entity.Day;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.validator.TimeValidator;

import java.time.LocalDate;

public class TimeService {

    private final int SECONDS_IN_MINUTE = 60;
    private final int SECONDS_IN_HOUR = 3600;
    private final String REGEX = "\\d+";

    public Response<Integer> checkMonth(int month) {
        TimeValidator validator = new TimeValidator();
                return validator.validateMonth(month) ?
                        ResponseHelper.makeOkResponse(month) :
                        ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);

    }

    public Response<Integer> checkYear(int year) {
        TimeValidator validator = new TimeValidator();
            return validator.validateYear(year) ?
                    ResponseHelper.makeOkResponse(year) :
                    ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
    }

    public Response<Integer> getNumberOfDays(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int numberOfDays = date.lengthOfMonth();
        return ResponseHelper.makeOkResponse(numberOfDays);
    }

    public Response<Integer> checkNumberOfSeconds(int numberOfSeconds) {
        TimeValidator validator = new TimeValidator();
            return validator.validateNumberOfSeconds(numberOfSeconds) ?
                    ResponseHelper.makeOkResponse(numberOfSeconds) :
                    ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);

    }

    public Response<Day> calculateNumberOfHoursMinutesSeconds(int value) {
        Day day = new Day();
        day.setHour(value / SECONDS_IN_HOUR);
        day.setMinute(value % SECONDS_IN_HOUR / SECONDS_IN_MINUTE);
        day.setSecond(value % SECONDS_IN_HOUR % SECONDS_IN_MINUTE);
        return ResponseHelper.makeOkResponse(day);
    }
}
