package com.epam.shcherbina.parser;

import com.epam.shcherbina.exception.ConversionException;

public class NumberParser {
    public int parseToInt(String value) throws ConversionException {
        try {
            int number = Integer.parseInt(value);
            return number;
        } catch (NumberFormatException e) {
            throw new ConversionException(e);
        }
    }
    public double parseToDouble(String value) throws ConversionException {
        try {
            double number = Double.parseDouble(value);
            return number;
        } catch (NumberFormatException e) {
            throw new ConversionException(e);
        }
    }
}
