package com.epam.day1.service;

import com.epam.day1.entity.Point;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.validator.NumberValidator;

public class PointService {

    public Response<Point> checkCoordinatesValue(Double x, Double y) {
        NumberValidator validator = new NumberValidator();
        return validator.validateNumber(x) && validator.validateNumber(y) ?
                ResponseHelper.makeOkResponse(new Point(x, y)) :
                ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
    }

    public Response<Point> compareDistance(Point a, Point b) {
        return Math.hypot(a.getX(), a.getY()) > Math.hypot(b.getX(), b.getY()) ?
                ResponseHelper.makeOkResponse(b) :
                ResponseHelper.makeOkResponse(a);
    }
}

