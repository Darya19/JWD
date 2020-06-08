package com.epam.shcherbina.service;

import com.epam.shcherbina.entity.Point;
import com.epam.shcherbina.entity.ResultResponse;
import com.epam.shcherbina.entity.Status;
import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.validator.NumberValidator;

public class PointService {

    public ResultResponse<Double> getCoordinate(String value) {
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

    public ResultResponse<Point> compareDistance(Point a, Point b) {
        if (Math.hypot(a.getX(), a.getY()) > Math.hypot(b.getX(), b.getY())) {
            return new ResultResponse<Point>(Status.OK,"none", b);
        } else {
            return new ResultResponse<Point>(Status.OK,"none", a);
        }
    }
}
