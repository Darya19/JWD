package com.epam.development.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareArea {
    private final double PI = 3.14;

    public static void main(String[] args) throws IOException {
        SquareArea squareArea = new SquareArea();
        double bigSquare = squareArea.getBigSquare();
        double smallSquare = squareArea.getSmallSquare(bigSquare);
        double difference = bigSquare / smallSquare;
        System.out.println(smallSquare);
        System.out.println(difference);
    }

    public double getBigSquare() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double bigSquare = Double.parseDouble(reader.readLine());
        reader.close();
        return bigSquare;
    }

    public double getSmallSquare(double bigSquare) {
        double areaOfCircle = PI * (bigSquare/4.0);
        double smallSquare = areaOfCircle / PI /2.0;
        return smallSquare;
    }
}
