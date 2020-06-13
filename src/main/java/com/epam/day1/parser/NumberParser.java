package com.epam.day1.parser;

import com.epam.day1.exception.CustomException;

public class NumberParser {

    public int parseToInt(String value) throws CustomException {
        try {
            int number = Integer.parseInt(value);
            return number;
        } catch (NumberFormatException e) {
            throw new CustomException("Parsing issues",e);
        }
    }

    public double parseToDouble(String value) throws CustomException {
        try {
            double number = Double.parseDouble(value);
            return number;
        } catch (NumberFormatException e) {
            throw new CustomException("Parsing issues",e);
        }
    }
}
