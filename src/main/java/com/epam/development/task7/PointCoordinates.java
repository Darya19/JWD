package com.epam.development.task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PointCoordinates {

    private double x1,y1;
    private double x2, y2;

    public static void main(String[] args) throws IOException {
        PointCoordinates pointCoordinates = new PointCoordinates();
        pointCoordinates.getPointsCoordinates();
        pointCoordinates.compareDistance();
    }
    public void getPointsCoordinates() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         x1 = Double.parseDouble(reader.readLine());
         y1 = Double.parseDouble(reader.readLine());
         x2 = Double.parseDouble(reader.readLine());
         y2 = Double.parseDouble(reader.readLine());
        reader.close();
    }

    public void compareDistance() {
       if (Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2)) > Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2))) {
            System.out.println("point (" + x2 + ", " + y2 +") closer");
        } else {
           System.out.println("point (" + x1 + ", " + y1 +") closer");
        }

    }
}
