package com.epam.development.task9;

public class Circle {
    private final double PI = 3.14;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getSquareOfCircle(){
        return PI * Math.pow(radius, 2);
    }

    public double getCircumferenceOfCircle(){
        return 2 * PI * radius;
    }
}
