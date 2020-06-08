package com.epam.shcherbina.validator;

public class TimeValidator {

    public boolean validateMonth(int month){
        return  (month <= 12 && month >= 1);
    }

    public boolean validateYear(int year){
        return  (year >= 1 && year <= 4000);
    }

    public boolean validateNumberOfSeconds(int numberOfSeconds){
        return   (numberOfSeconds > 1 && numberOfSeconds < 86400);
    }
}
