package com.epam.day1.service;

import com.epam.day1.exception.CustomException;
import com.epam.day1.parser.NumberParser;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class StatementService {

    private NumberParser parser;
    private NumberValidator validator;

    public StatementService() {
        this.parser = new NumberParser();
        this.validator = new NumberValidator();
    }

    public Response<List<Integer>> createListOfEvenNumbers(String... value) {
        List<Integer> listOfNumbers = new ArrayList<>();
        try {
            for (int i = 0; i < 4; i++) {
                int number = parser.parseToInt(value[i]);
                if (validator.validateNumber(number)) {
                    if (validator.checkEvenNumber(number)) {
                        listOfNumbers.add(number);
                    }
                } else {
                    return ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
                }
            }
            return ResponseHelper.makeOkResponse(listOfNumbers);
        } catch (CustomException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
        }
    }

    public Response<Boolean> trueOrFalseStatement(List<Integer> listOfEvenNumbers) {
        return listOfEvenNumbers.size() >= 2 ?
                ResponseHelper.makeOkResponse(true) :
                ResponseHelper.makeOkResponse(false);
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

    public Response<Integer> calculateSumOfDividers(int number) {
        int sumOfDividers = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sumOfDividers += i;
            }
        }
        return ResponseHelper.makeOkResponse(sumOfDividers);
    }

    public Response<Boolean> isPerfectNumber(int number, int sumOfDividers) {
        return number == sumOfDividers ?
                ResponseHelper.makeOkResponse(true) :
                ResponseHelper.makeOkResponse(false);
    }
}

