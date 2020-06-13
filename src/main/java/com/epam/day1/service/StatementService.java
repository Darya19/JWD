package com.epam.day1.service;

import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class StatementService {

    public Response<List<Integer>> createListOfEvenNumbers(List<Integer> list) {
        NumberValidator validator = new NumberValidator();
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (validator.validateNumber(list.get(i))) {
                if (validator.checkEvenNumber(list.get(i))) {
                    listOfNumbers.add(list.get(i));
                }
            } else {
                return ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
            }
        }
        return ResponseHelper.makeOkResponse(listOfNumbers);
    }


    public Response<Boolean> trueOrFalseStatement(List<Integer> listOfEvenNumbers) {
        return listOfEvenNumbers.size() >= 2 ?
                ResponseHelper.makeOkResponse(true) :
                ResponseHelper.makeOkResponse(false);
    }

    public Response<Integer> checkNumber(int number) {
        NumberValidator validator = new NumberValidator();
        return validator.validateNumber(number) ?
                ResponseHelper.makeOkResponse(number) :
                ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);

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

