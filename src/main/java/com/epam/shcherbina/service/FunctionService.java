package com.epam.shcherbina.service;

import com.epam.shcherbina.entity.ResultResponse;
import com.epam.shcherbina.entity.Status;
import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.validator.NumberValidator;
import com.sun.javafx.collections.MappingChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionService {

    public ResultResponse<Double> getValue(String value) {
    NumberParser parser = new NumberParser();
    NumberValidator validator = new NumberValidator();
    double x;
            try {
        x = parser.parseToDouble(value);
        if (validator.validateNumber(x)) {
            return new ResultResponse<Double>(Status.OK, "none", x);
        } else {
            return new ResultResponse<Double>(Status.ERROR, "Invalid number", null);
        }
    } catch (
    InvalidNumberException e) {
        return new ResultResponse<Double>(Status.ERROR, "Invalid number", null);
    }
}
    public ResultResponse<Double> calculateY(double x){
        double y;
        if(x >= 3) {
            y = -(Math.pow(x,2)) + 3 * x + 9;
        } else {
            y = 1 / (Math.pow(x, 3) - 6);
        }
        return new ResultResponse<>(Status.OK, "none", y);
    }

    public ResultResponse<Map<Double, Double>> calculateXAndY(double a, double b, double h) {
        Map<Double, Double> mapOfValues = new HashMap<>();
        double x;
        double y;
        for (x = a; x <= b; x += h) {
            y = Math.tan(x);
            mapOfValues.put(x, y);
        }
        return new ResultResponse<>(Status.OK, "none", mapOfValues);
    }
}
