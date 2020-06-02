package com.epam.shcherbina.parser;

import com.epam.shcherbina.exception.InvalidNumberException;

public class NumberParser {
    public int numberParser(String value) throws InvalidNumberException {
        try {
            int number = Integer.parseInt(value);
            return number;
        } catch (NumberFormatException e) {
            throw new InvalidNumberException(e);
        }
    }
}
