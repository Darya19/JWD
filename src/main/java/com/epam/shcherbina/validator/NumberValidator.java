package com.epam.shcherbina.validator;

public class NumberValidator {

    public boolean ValidateNumber(int number){
         return number >= 1 && number <= 1000;
    }

    public boolean ValidateNumber(double number){
        return number >= -1.0 && number <= 1000.0;
    }
}
