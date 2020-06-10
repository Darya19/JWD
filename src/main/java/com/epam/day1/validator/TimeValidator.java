package com.epam.day1.validator;

public class TimeValidator {

    private final int MIN_SECONDS_PER_DAY = 1;
    private final int MAX_SECONDS_PER_DAY = 86400;
    private final int MIN_MONTHS_PER_YEAR = 1;
    private final int MAX_MONTHS_PER_YEAR = 12;
    private final int MIN_YEAR = 1;
    private final int MAX_YEAR = 4000;

    public boolean validateMonth(int month) {
        return (month <= MAX_MONTHS_PER_YEAR && month >= MIN_MONTHS_PER_YEAR);
    }

    public boolean validateYear(int year) {
        return (year >= MIN_YEAR && year <= MAX_YEAR);
    }

    public boolean validateNumberOfSeconds(int numberOfSeconds) {
        return (numberOfSeconds > MIN_SECONDS_PER_DAY && numberOfSeconds < MAX_SECONDS_PER_DAY);
    }
}
