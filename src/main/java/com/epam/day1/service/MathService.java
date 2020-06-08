package com.epam.day1.service;

import com.epam.day1.entity.Response;
import com.epam.day1.exception.CustomException;
import com.epam.day1.parser.NumberParser;
import com.epam.day1.validator.NumberValidator;

public class MathService {

    private NumberParser parser;
    private NumberValidator validator;

    public MathService() {
        this.parser = new NumberParser();
        this.validator = new NumberValidator();
    }

    public Response<Integer> calculateLastDigit(String value) {
        int number;
        try {
            number = parser.parseToInt(value);
            return validator.validateNumber(number) ?
                    ResponseHelper.makeOkResponse(number % 10) :
                    ResponseHelper.makeErrorResponse();
        } catch (CustomException e) {
            return ResponseHelper.makeErrorResponse();
        }
    }

    public Response<Integer> calculateLastDigitOfSquare(int value) {
        int number = (int) (Math.pow(value, 2)) % 10;
        return ResponseHelper.makeOkResponse(number);
    }
}
