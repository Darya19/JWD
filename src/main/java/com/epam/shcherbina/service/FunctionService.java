package com.epam.shcherbina.service;

import com.epam.shcherbina.entity.Response;
import com.epam.shcherbina.entity.Status;
import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.validator.NumberValidator;

import java.util.HashMap;
import java.util.Map;

public class FunctionService {

    public Response<Double> getValue(String value) {
    NumberParser parser = new NumberParser();
    NumberValidator validator = new NumberValidator();
    double x;
            try {
        x = parser.parseToDouble(value);
        if (validator.validateNumber(x)) {
            return new Response<Double>(Status.OK, "none", x);
        } else {
            return new Response<Double>(Status.ERROR, "Invalid number", null);
        }
    } catch (
    InvalidNumberException e) {
        return new Response<Double>(Status.ERROR, "Invalid number", null);
    }
}
    public Response<Double> calculateY(double x){
        double y;
        if(x >= 3) {
            y = -(Math.pow(x,2)) + 3 * x + 9;
        } else {
            y = 1 / (Math.pow(x, 3) - 6);
        }
        return new Response<>(Status.OK, "none", y);
    }

    public Response<Map<Double, Double>> calculateXAndY(double a, double b, double h) {
        Map<Double, Double> mapOfValues = new HashMap<>();
        double x;
        double y;
        for (x = a; x <= b; x += h) {
            y = Math.tan(x);
            mapOfValues.put(x, y);
        }
        return new Response<>(Status.OK, "none", mapOfValues);
    }
}
