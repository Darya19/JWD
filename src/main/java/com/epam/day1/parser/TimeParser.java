package com.epam.day1.parser;

import com.epam.day1.exception.CustomException;

public class TimeParser {

    public int parseMonthNameToInt(String date) throws CustomException {
        int month = 0;
        switch (date) {
            case "january":
                month = 1;
                break;
            case "february":
                month = 2;
                break;
            case "march":
                month = 3;
                break;
            case "april":
                month = 4;
                break;
            case "may":
                month = 5;
                break;
            case "june":
                month = 6;
                break;
            case "july":
                month = 7;
                break;
            case "august":
                month = 8;
                break;
            case "september":
                month = 9;
                break;
            case "october":
                month = 10;
                break;
            case "november":
                month = 11;
                break;
            case "december":
                month = 12;
                break;
            default:
                throw new CustomException("Incorrect month name");
        }
        return month;
    }
}
