package com.epam.day1.service;

import com.epam.day1.entity.Point;
import com.epam.day1.exception.CustomException;
import com.epam.day1.parser.NumberParser;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.validator.NumberValidator;

public class PointService {

    private NumberParser parser;
    private NumberValidator validator;

    public PointService() {
        this.parser = new NumberParser();
        this.validator = new NumberValidator();
    }

    public Response<Point> checkCoordinatesValue(String coordinateX, String coordinateY) {
        double x;
        double y;
        try {
            x = parser.parseToDouble(coordinateX);
            y = parser.parseToDouble(coordinateY);
            return validator.validateNumber(x) && validator.validateNumber(y) ?
                    ResponseHelper.makeOkResponse(new Point(x, y)) :
                    ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
        } catch (CustomException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
        }
    }

    public Response<Point> compareDistance(Point a, Point b) {
        return Math.hypot(a.getX(), a.getY()) > Math.hypot(b.getX(), b.getY()) ?
                ResponseHelper.makeOkResponse(b) :
                ResponseHelper.makeOkResponse(a);
    }
}

