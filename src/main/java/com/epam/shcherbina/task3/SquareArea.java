package com.epam.shcherbina.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareArea {

    private final double PI = 3.14;

    public static void main(String[] args) throws IOException, InvalidSquareException {
        SquareArea squareArea = new SquareArea();
        double areaOfBigSquare = squareArea.getAreaOfBigSquare();
        double areaOfSmallSquare = squareArea.getAreaOfSmallSquare(areaOfBigSquare);
        double difference = areaOfBigSquare / areaOfSmallSquare;
        System.out.println(areaOfSmallSquare);
        System.out.println(difference);
    }

    public double getAreaOfBigSquare() throws IOException, InvalidSquareException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double AreaOfBigSquare = Double.parseDouble(reader.readLine());
        if(AreaOfBigSquare < 1 ) {
            throw new InvalidSquareException("Invalid Square area");
        }
        reader.close();
        return AreaOfBigSquare;
    }

    public double getAreaOfSmallSquare(double AreaOfBigSquare) {
        double areaOfCircle = PI * (AreaOfBigSquare/4.0);
        double areaOfSmallSquare = 2.0 * areaOfCircle / PI ;
        return areaOfSmallSquare;
    }
}
