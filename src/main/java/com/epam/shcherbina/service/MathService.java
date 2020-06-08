package com.epam.shcherbina.service;

import com.epam.shcherbina.entity.Response;
import com.epam.shcherbina.entity.Status;
import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.validator.NumberValidator;

public class MathService {

    public Response<Integer> calculateLastDigit(String value) {
        NumberParser parser = new NumberParser();
        NumberValidator validator = new NumberValidator();
        int number;
            try {
                number = parser.parseToInt(value);
                if (validator.validateNumber(number)) {
                    return new Response<Integer>(Status.OK, "none", number % 10);
                } else {
                    return new Response<Integer>(Status.ERROR, "Invalid number", null);
                }
            } catch (InvalidNumberException e) {
                return new Response<Integer>(Status.ERROR, "Invalid number", null);
            }
        }

    public Response<Integer> calculateSquareOfLastDigit(int value) {
        int number = (int) (Math.pow(value, 2)) % 10;
        return new Response<Integer>(Status.OK, "none",number);
    }
}
