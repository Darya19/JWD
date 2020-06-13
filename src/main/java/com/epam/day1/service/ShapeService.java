package com.epam.day1.service;

import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.validator.NumberValidator;

public class ShapeService {

    private final double PI = 3.14;

    public Response<Double> checkRadius(Double radius) {
        NumberValidator validator = new NumberValidator();
        return validator.validateNumber(radius) ?
                ResponseHelper.makeOkResponse(radius) :
                ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
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

