package com.epam.shcherbina.main;

import com.epam.shcherbina.console.ShowResult;
import com.epam.shcherbina.service.ShapeService;

public class ShapeMain {

    public static void main(String[] args) {
        ShapeService service = new ShapeService();
        ShowResult result = new ShowResult();
       double smallSquare = service.getAreaOfSmallSquare("149");
        result.echoResult(smallSquare);
        result.echoResult(service.getDifferenceInSquares(369, smallSquare));
        result.echoResult(service.getAreaOfSmallSquare("gghghgu"));

        result.echoResult(service.getSquareOfCircle("35656"));
        result.echoResult(service.getSquareOfCircle("-3"));
        result.echoResult(service.getSquareOfCircle(456.3));
        result.echoResult(service.getSquareOfCircle(-43));
        result.echoResult(service.getCircumferenceOfCircle("35656232356356565"));
        result.echoResult(service.getCircumferenceOfCircle(-400));
    }
}
