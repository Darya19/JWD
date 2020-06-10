package com.epam.day1.service;

import com.epam.day1.exception.CustomException;
import com.epam.day1.parser.NumberParser;
import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.validator.NumberValidator;

import java.util.HashMap;
import java.util.Map;

public class FunctionService {

    private NumberParser parser;
    private NumberValidator validator;

    public FunctionService() {
        this.parser = new NumberParser();
        this.validator = new NumberValidator();
    }

    public Response<Double> checkXValue(String value) {
        double x;
        try {
            x = parser.parseToDouble(value);
            return validator.validateNumber(x) ?
                    ResponseHelper.makeOkResponse(x) :
                    ResponseHelper.makeErrorResponse(ErrorCode.VALIDATION_ERROR);
        } catch (CustomException e) {
            return ResponseHelper.makeErrorResponse(ErrorCode.PARSING_ERROR);
        }
    }

    public Response<Double> calculateY(double x) {
        double y;
        if (x >= 3) {
            y = -(Math.pow(x, 2)) + 3 * x + 9;
        } else {
            if ((Math.pow(x, 3) - 6) != 0) {
                y = 1 / (Math.pow(x, 3) - 6);
            } else {
                return ResponseHelper.makeErrorResponse(ErrorCode.DIVISION_BY_ZERO);
            }
        }
        return ResponseHelper.makeOkResponse(y);
    }

    public Response<Map<Double, Double>> calculateXAndY(double a, double b, double h) {
        Map<Double, Double> mapOfValues = new HashMap<>();
        double x;
        double y;
        for (x = a; x <= b; x += h) {
            y = Math.tan(x);
            mapOfValues.put(x, y);
        }
        return ResponseHelper.makeOkResponse(mapOfValues);
    }
}
