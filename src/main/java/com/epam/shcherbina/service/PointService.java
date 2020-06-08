package com.epam.shcherbina.service;

import com.epam.shcherbina.entity.Point;
import com.epam.shcherbina.entity.Response;
import com.epam.shcherbina.entity.Status;
import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.validator.NumberValidator;

public class PointService {

    public Response<Double> getCoordinate(String value) {
        NumberParser parser = new NumberParser();
        NumberValidator validator = new NumberValidator();
        double number;
        try {
            number = parser.parseToDouble(value);
            if (validator.validateNumber(number)) {
                return new Response<Double>(Status.OK, "none", number);
            } else {
                return new Response<Double>(Status.ERROR, "Invalid number", null);
            }
        } catch (InvalidNumberException e) {
            return new Response<Double>(Status.ERROR, "Invalid number", null);
        }
    }

    public Response<Point> compareDistance(Point a, Point b) {
        if (Math.hypot(a.getX(), a.getY()) > Math.hypot(b.getX(), b.getY())) {
            return new Response<Point>(Status.OK,"none", b);
        } else {
            return new Response<Point>(Status.OK,"none", a);
        }
    }
}
