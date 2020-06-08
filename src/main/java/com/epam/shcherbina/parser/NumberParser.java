package com.epam.shcherbina.parser;

import com.epam.shcherbina.exception.InvalidNumberException;

public class NumberParser {
    public int parseToInt(String value) throws InvalidNumberException {
        try {
            int number = Integer.parseInt(value);
            return number;
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Invalid number",e);
        }
    }
    public double parseToDouble(String value) throws InvalidNumberException {
        try {
            double number = Double.parseDouble(value);
            return number;
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Invalid number",e);
        }
    }
}
