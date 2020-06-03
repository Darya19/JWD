package com.epam.shcherbina.util;

public class ShapeHelper {

    private final double PI = 3.14;

    public double getAreaOfCircleInscribedInSquare(double areaOfBigSquare) {
        return PI * (areaOfBigSquare/4.0);
    }

    public double getAreaOfSquareInscribedInCircle(double areaOfCircle) {
            return 2.0 * areaOfCircle / PI;
    }

    public double getDifferenceInSquares(double areaOfBigSquare, double areaOfSmallSquare) {
        return areaOfBigSquare / areaOfSmallSquare;
    }

    public double getSquareOfCircle(double radius){
        return PI * Math.pow(radius, 2);
    }

    public double getCircumferenceOfCircle(double radius){
        return 2 * PI * radius;
    }

}
