package com.epam.shcherbina.service;

import com.epam.shcherbina.entity.ResultResponse;
import com.epam.shcherbina.entity.Status;
import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.validator.NumberValidator;

public class ShapeService {

    private final double PI = 3.14;

    public ResultResponse<Double> getNumber(String value) {
        NumberParser parser = new NumberParser();
        NumberValidator validator = new NumberValidator();
        double number;
        try {
            number = parser.parseToDouble(value);
            if (validator.validateNumber(number)) {
                return new ResultResponse<Double>(Status.OK, "none", number);
            } else {
                return new ResultResponse<Double>(Status.ERROR, "Invalid number", null);
            }
        } catch (InvalidNumberException e) {
            return new ResultResponse<Double>(Status.ERROR, "Invalid number", null);
        }
    }

    public ResultResponse<Double> calculateAreaOfCircleInscribedInSquare(double areaOfBigSquare){
        double areaOfCircle = PI * (areaOfBigSquare / 4.0);
        return new ResultResponse<Double>(Status.OK, "none", areaOfCircle);
    }

    public ResultResponse<Double> calculateAreaOfSquareInscribedInCircle(double areaOfCircle) {
              double areaOfSquare = 2.0 * areaOfCircle / PI;
            return new ResultResponse<Double>(Status.OK, "none", areaOfSquare);
    }

    public ResultResponse<Double> calculateDifferenceInSquares(double bigSquare, double smallSquare){
        double difference =  bigSquare / smallSquare;
      return  new ResultResponse<>(Status.OK, "none", difference);
    }

    public ResultResponse<Double> calculateAreaOfCircle(double radius) {
                double areaOfCircle = PI * Math.pow(radius, 2);
                return new ResultResponse<Double>(Status.OK, "none", areaOfCircle);
    }

    public ResultResponse<Double> calculateCircumferenceOfCircle(double radius) {
        double circumferenceOfCircle = PI * 2 * radius;
        return new ResultResponse<Double>(Status.OK, "none", circumferenceOfCircle);
    }
}

