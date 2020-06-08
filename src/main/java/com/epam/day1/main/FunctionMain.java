package com.epam.day1.main;

import com.epam.day1.console.PrintResult;
import com.epam.day1.entity.Response;
import com.epam.day1.service.FunctionService;

import java.util.Map;

public class FunctionMain {
    public static void main(String[] args) {
        FunctionService service = new FunctionService();
        PrintResult print = new PrintResult();
        Response<Double> result = service.checkCoordinateValue("35.2");
        double x = result.getResult();
        result = service.calculateY(x);
        print.echoResult(result.toString());

        result = service.checkCoordinateValue("1111");
        print.echoResult(result.toString());

        result = service.checkCoordinateValue("jhhkhik");
        print.echoResult(result.toString());

        double a = service.checkCoordinateValue("36.25").getResult();
        double b = service.checkCoordinateValue("148.25").getResult();
        double h = service.checkCoordinateValue("2").getResult();
       Map<Double, Double> mapOfValues = service.calculateXAndY(a, b, h).getResult();
       print.echoTableResult(mapOfValues);

    }
}
