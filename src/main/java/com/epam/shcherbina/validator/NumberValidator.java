package com.epam.shcherbina.validator;

public class NumberValidator {
    final int MAX_VALUE = 1;
    final int MIN_VALUE = 1000;

    public boolean validateNumber(double number) {
        return number >= MIN_VALUE && number <= MAX_VALUE;
    }

    public boolean checkEvenNumber(int number) {
        return number % 2 == 0;
    }
}
