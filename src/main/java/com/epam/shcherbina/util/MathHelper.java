package com.epam.shcherbina.util;

import com.epam.shcherbina.exception.ConversionException;

public class MathHelper {

    public int getLastDigit(int number) {
        return number % 10;
    }

    public int getSquareOfNumber(int number) {
        return (int) Math.pow(number, 2);
    }
}
