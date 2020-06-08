package com.epam.day1.main;

import com.epam.day1.console.PrintResult;
import com.epam.day1.entity.Response;
import com.epam.day1.service.ShapeService;

public class ShapeMain {

    public static void main(String[] args) {
        ShapeService service = new ShapeService();
        PrintResult result = new PrintResult();
        Response<Double> response = service.checkRadius("149");
        double bigSquare = response.getResult();
        double areaOfCircle = service.calculateAreaOfCircleInscribedInSquare(bigSquare).getResult();
        response = service.calculateAreaOfSquareInscribedInCircle(areaOfCircle);
        result.echoResult(response.getResult().toString());
        response = service.calculateDifferenceInSquares(bigSquare, response.getResult());
        result.echoResult( response.getResult().toString());

        response = service.checkRadius("149lkjk");
        result.echoResult(response.toString());

        double radius = service.checkRadius("35656").getResult();
        result.echoResult(service.calculateAreaOfCircle(radius).toString());
        result.echoResult(service.calculateCircumferenceOfCircle(radius).toString());
        radius = service.checkRadius("hjgj").getResult();
        result.echoResult(service.calculateAreaOfCircle(radius).toString());
        result.echoResult(service.calculateCircumferenceOfCircle(radius).toString());
        radius = service.checkRadius("6").getResult();
        result.echoResult(service.calculateAreaOfCircle(radius).toString());
        result.echoResult(service.calculateCircumferenceOfCircle(radius).toString());
    }
}
