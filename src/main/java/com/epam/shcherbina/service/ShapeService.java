package com.epam.shcherbina.service;

import com.epam.shcherbina.exception.ConversionException;
import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.util.ShapeHelper;
import com.epam.shcherbina.validator.NumberValidator;

public class ShapeService {

    private double numberIsCorrect(String value) throws ConversionException, InvalidNumberException {
        NumberParser parser = new NumberParser();
        NumberValidator validator = new NumberValidator();
        double number;
            number = parser.parseToDouble(value);
            if (validator.ValidateNumber(number)) {
                return number;
            } else throw new InvalidNumberException("Incorrect number");
    }

    private double numberIsCorrect(double value) throws InvalidNumberException {
        NumberValidator validator = new NumberValidator();
        if (validator.ValidateNumber(value)) {
            return value;
        } else throw new InvalidNumberException("Incorrect number");
    }


    public double getAreaOfSmallSquare(String value) {
        ShapeHelper helper = new ShapeHelper();
        double number;
        try { number = numberIsCorrect(value);
              number = helper.getAreaOfCircleInscribedInSquare(number);
              number = helper.getAreaOfSquareInscribedInCircle(number);
              return number;
        } catch (ConversionException | InvalidNumberException e) {
            return -1;
        }
    }

    public double getAreaOfSmallSquare(double value) {
        ShapeHelper helper = new ShapeHelper();
        double number;
        try { number = numberIsCorrect(value);
             number = helper.getAreaOfCircleInscribedInSquare(number);
             number = helper.getAreaOfSquareInscribedInCircle(number);
            return number;
        } catch (InvalidNumberException e) {
            return -1;
        }
    }

    public double getDifferenceInSquares(double bigSquare, double smallSquare){
        ShapeHelper helper = new ShapeHelper();
        return helper.getDifferenceInSquares(bigSquare, smallSquare);
    }

    public double getSquareOfCircle(String radius){
        double number;
        ShapeHelper helper = new ShapeHelper();
        try {
            number = numberIsCorrect(radius);
            return helper.getSquareOfCircle(number);
        } catch (ConversionException | InvalidNumberException e) {
            return -1;
        }
    }

    public double getSquareOfCircle(double radius) {
        ShapeHelper helper = new ShapeHelper();
        double number;
        try {
            number = numberIsCorrect(radius);
            return helper.getSquareOfCircle(radius);
        } catch (InvalidNumberException e) {
            return -1;
        }
    }

    public double getCircumferenceOfCircle(String radius){
        double number;
        ShapeHelper helper = new ShapeHelper();
        try {
            number = numberIsCorrect(radius);
            return helper.getCircumferenceOfCircle(number);
        } catch (ConversionException | InvalidNumberException e) {
            return -1;
        }
    }

    public double getCircumferenceOfCircle(double radius) {
        ShapeHelper helper = new ShapeHelper();
        double number;
        try {
            number = numberIsCorrect(radius);
            return helper.getCircumferenceOfCircle(radius);
        } catch (InvalidNumberException e) {
            return -1;
        }
    }
    }

