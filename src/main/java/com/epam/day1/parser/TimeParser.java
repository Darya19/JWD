package com.epam.day1.parser;

import com.epam.day1.exception.CustomException;

import java.time.Month;

public class TimeParser {

    private final String REGEX = "\\d+";

    public int parseDate(String value) throws CustomException {
        int month = 0;
        if (value.matches(REGEX)) {
            month = Integer.parseInt(value);
        } else {
            for (Month tmp : Month.values()) {
                if (tmp.toString().equals(value.toUpperCase())) {
                    month = tmp.getValue();
                }
            }
        }
        if (month == 0) {
            throw new CustomException("Parsing issue");
        } else {
            return month;
        }
    }
}
