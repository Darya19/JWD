package com.epam.shcherbina.main;

import com.epam.shcherbina.console.PrintResult;
import com.epam.shcherbina.entity.ResultResponse;
import com.epam.shcherbina.service.FunctionService;

import java.util.Map;

public class FunctionMain {
    public static void main(String[] args) {
        FunctionService service = new FunctionService();
        PrintResult print = new PrintResult();
        ResultResponse<Double> result = service.getValue("35.2");
        double x = result.getResult();
        result = service.calculateY(x);
        print.echoResult(result.toString());

        result = service.getValue("1111");
        print.echoResult(result.toString());

        result = service.getValue("jhhkhik");
        print.echoResult(result.toString());

        double a = service.getValue("36.25").getResult();
        double b = service.getValue("148.25").getResult();
        double h = service.getValue("2").getResult();
       Map<Double, Double> mapOfValues = service.calculateXAndY(a, b, h).getResult();
       print.echoTableResult(mapOfValues);

    }
}
