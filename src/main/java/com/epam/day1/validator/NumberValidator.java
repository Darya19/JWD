package com.epam.day1.validator;

public class NumberValidator {

   private final int MAX_VALUE = 1000;
   private final int MIN_VALUE = 1;

    public boolean validateNumber(double number) {
        return number >= MIN_VALUE && number <= MAX_VALUE;
    }

    public boolean checkEvenNumber(int number) {
        return number % 2 == 0;
    }
}
