package com.epam.day1.service;

import com.epam.day1.entity.Point;
import com.epam.day1.entity.Response;
import com.epam.day1.exception.CustomException;
import com.epam.day1.parser.NumberParser;
import com.epam.day1.validator.NumberValidator;

public class PointService {

    private NumberParser parser;
    private NumberValidator validator;

    public PointService() {
        this.parser = new NumberParser();
        this.validator = new NumberValidator();
    }

    public Response<Double> checkCoordinate(String coordinate) {
        double number;
        try {
            number = parser.parseToDouble(coordinate);
            return validator.validateNumber(number) ?
                    ResponseHelper.makeOkResponse(number) :
                    ResponseHelper.makeErrorResponse();
        } catch (CustomException e) {
            return ResponseHelper.makeErrorResponse();
        }
    }

    public Response<Point> compareDistance(Point a, Point b) {
        return Math.hypot(a.getX(), a.getY()) > Math.hypot(b.getX(), b.getY()) ?
                ResponseHelper.makeOkResponse(b) :
                ResponseHelper.makeOkResponse(a);
    }
}

