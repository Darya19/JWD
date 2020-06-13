package com.epam.day1.service;

import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.validator.NumberValidator;

public class MathService {

    public Response<Integer> checkNumber(int number) {
        NumberValidator validator = new NumberValidator();
        return validator.validateNumber(number) ?
                ResponseHelper.makeOkResponse(number) :
                ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
    }

    public Response<Integer> calculateLastDigitOfSquare(int value) {
        int number = (int) (Math.pow(value, 2)) % 10;
        return ResponseHelper.makeOkResponse(number);
    }
}
