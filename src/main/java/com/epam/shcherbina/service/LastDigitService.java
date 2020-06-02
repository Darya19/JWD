package com.epam.shcherbina.service;

import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.validator.ValidateNumber;

public class LastDigitService {

    public int getLastDigit(int number) throws InvalidNumberException {
       ValidateNumber validator = new ValidateNumber();
       if (validator.checkNumber(number)){
        return number % 10;}
       else {
           throw new InvalidNumberException("Incorrect number");
       }
    }

    public int getSquareOfLastDigit(int digit) {
        int squareOfLastDigit  = (int) Math.pow(digit, 2);
        return squareOfLastDigit % 10;
    }
}
