package com.epam.day1.service;

import com.epam.day1.exception.CustomException;
import com.epam.day1.parser.NumberParser;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.validator.NumberValidator;

public class ShapeService {

    private final double PI = 3.14;
    private NumberParser parser;
    private NumberValidator validator;

    public ShapeService() {
        this.parser = new NumberParser();
        this.validator = new NumberValidator();
    }

    public Response<Double> checkRadius(String value) {
        double radius;
        try {
            radius = parser.parseToDouble(value);
            return validator.validateNumber(radius) ?
                    ResponseHelper.makeOkResponse(radius) :
                    ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
        } catch (CustomException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
        }
    }

    public Response<Double> calculateAreaOfCircleInscribedInSquare(double areaOfBigSquare) {
        double areaOfCircle = PI * (areaOfBigSquare / 4.0);
        return ResponseHelper.makeOkResponse(areaOfCircle);
    }

    public Response<Double> calculateAreaOfSquareInscribedInCircle(double areaOfCircle) {
        double areaOfSquare = 2.0 * areaOfCircle / PI;
        return ResponseHelper.makeOkResponse(areaOfSquare);
    }

    public Response<Double> calculateDifferenceInSquares(double bigSquare, double smallSquare) {
        double difference = bigSquare / smallSquare;
        return ResponseHelper.makeOkResponse(difference);
    }

    public Response<Double> calculateAreaOfCircle(double radius) {
        double areaOfCircle = PI * Math.pow(radius, 2);
        return ResponseHelper.makeOkResponse(areaOfCircle);
    }

    public Response<Double> calculateCircumferenceOfCircle(double radius) {
        double circumferenceOfCircle = PI * 2 * radius;
        return ResponseHelper.makeOkResponse(circumferenceOfCircle);
    }
}

