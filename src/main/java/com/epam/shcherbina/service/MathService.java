package com.epam.shcherbina.service;

import com.epam.shcherbina.exception.ConversionException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.util.MathHelper;
import com.epam.shcherbina.validator.NumberValidator;

public class MathService {

        public int getSquareOfLastDigit(String value) {
            NumberParser parser = new NumberParser();
            NumberValidator validator = new NumberValidator();
            MathHelper helper = new MathHelper();
            int number;
            try {
                 number = parser.parseToInt(value);
                if (validator.ValidateNumber(number)) {
                number = helper.getLastDigit(number);
                 number = helper.getSquareOfNumber(number);
                 number = helper.getLastDigit(number);
                    return number;
                } else return -1;
            } catch (ConversionException e) {
                return -1;
            }
        }

    public int getSquareOfLastDigit(int value) {
        NumberValidator validator = new NumberValidator();
        MathHelper helper = new MathHelper();
        int number;
            if (validator.ValidateNumber(value)) {
                number = helper.getLastDigit(value);
                number = helper.getSquareOfNumber(number);
                number = helper.getLastDigit(number);
                return number;
            } else return -1;
    }
}
