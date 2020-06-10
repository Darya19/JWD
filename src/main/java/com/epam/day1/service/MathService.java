package com.epam.day1.service;

import com.epam.day1.exception.CustomException;
import com.epam.day1.parser.NumberParser;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.validator.NumberValidator;

public class MathService {

    private NumberParser parser;
    private NumberValidator validator;

    public MathService() {
        this.parser = new NumberParser();
        this.validator = new NumberValidator();
    }

    public Response<Integer> checkNumber(String value) {
        int number;
        try {
            number = parser.parseToInt(value);
            return validator.validateNumber(number) ?
                    ResponseHelper.makeOkResponse(number) :
                    ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
        } catch (CustomException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
        }
    }

    public Response<Integer> calculateLastDigitOfSquare(int value) {
        int number = (int) (Math.pow(value, 2)) % 10;
        return ResponseHelper.makeOkResponse(number);
    }
}
