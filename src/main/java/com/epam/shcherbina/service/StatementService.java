package com.epam.shcherbina.service;

import com.epam.shcherbina.entity.Response;
import com.epam.shcherbina.entity.Status;
import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class StatementService {
    public Response<List<Integer>> createListOfEvenNumbers(String... value) {
        List<Integer> listOfNumbers = new ArrayList<>();
        NumberParser parser = new NumberParser();
        NumberValidator validator = new NumberValidator();
        try {
            for (int i = 0; i < 4; i++) {
                int number = parser.parseToInt(value[i]);
                if (validator.checkEvenNumber(number)) {
                    listOfNumbers.add(number);
                }
            }
            return new Response<List<Integer>>(Status.OK, "none", listOfNumbers);
        } catch (InvalidNumberException e) {
            return new Response<>(Status.ERROR, "Invalid Number", new ArrayList<Integer>());
        }
    }


    public Response<Boolean> isPerfectNumber(List<Integer> listOfNumbers) {
        if (listOfNumbers.size() >= 2) {
            return new Response<>(Status.OK, "none", true);
        } else {
            return new Response<>(Status.OK, "none", false);
        }
    }

    public Response<Integer> getNumber(String value) {
        NumberParser parser = new NumberParser();
        NumberValidator validator = new NumberValidator();
        int number;
        try {
            number = parser.parseToInt(value);
            if (validator.validateNumber(number)) {
                return new Response<Integer>(Status.OK, "none", number);
            } else {
                return new Response<Integer>(Status.ERROR, "Invalid number", null);
            }
        } catch (InvalidNumberException e) {
            return new Response<Integer>(Status.ERROR, "Invalid number", null);
        }
    }
    public Response<Integer> calculateSumOfDividers(int number) {
        int sumOfDividers = 0;
        for (int i = 1; i < number; i++) {
            if(number % i == 0){
                sumOfDividers += i;
            }
        }
        return  new Response<>(Status.OK,"none", sumOfDividers);
    }

    public Response<Boolean> isPerfectNumber(int number, int sumOfDividers) {
        if (number == sumOfDividers) {
            return new Response<>(Status.OK, "none", true);
        } else {
            return new Response<>(Status.OK, "none", false);
        }
    }
}
