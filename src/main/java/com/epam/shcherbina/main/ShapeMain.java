package com.epam.shcherbina.main;

import com.epam.shcherbina.console.PrintResult;
import com.epam.shcherbina.entity.ResultResponse;
import com.epam.shcherbina.service.ShapeService;

public class ShapeMain {

    public static void main(String[] args) {
        ShapeService service = new ShapeService();
        PrintResult result = new PrintResult();
        ResultResponse<Double> response = service.getNumber("149");
        double bigSquare = response.getResult();
        double areaOfCircle = service.calculateAreaOfCircleInscribedInSquare(bigSquare).getResult();
        response = service.calculateAreaOfSquareInscribedInCircle(areaOfCircle);
        result.echoResult(response.getResult().toString());
        response = service.calculateDifferenceInSquares(bigSquare, response.getResult());
        result.echoResult( response.getResult().toString());

        response = service.getNumber("149lkjk");
        result.echoResult(response.toString());

        double radius = service.getNumber("35656").getResult();
        result.echoResult(service.calculateAreaOfCircle(radius).toString());
        result.echoResult(service.calculateCircumferenceOfCircle(radius).toString());
        radius = service.getNumber("hjgj").getResult();
        result.echoResult(service.calculateAreaOfCircle(radius).toString());
        result.echoResult(service.calculateCircumferenceOfCircle(radius).toString());
        radius = service.getNumber("6").getResult();
        result.echoResult(service.calculateAreaOfCircle(radius).toString());
        result.echoResult(service.calculateCircumferenceOfCircle(radius).toString());
    }
}
