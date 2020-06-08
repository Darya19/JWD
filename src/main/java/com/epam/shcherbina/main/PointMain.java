package com.epam.shcherbina.main;

import com.epam.shcherbina.console.PrintResult;
import com.epam.shcherbina.entity.Point;
import com.epam.shcherbina.service.PointService;

public class PointMain {
    public static void main(String[] args) {
        PointService service = new PointService();
        PrintResult print = new PrintResult();
        double x = service.getCoordinate("56.1").getResult();
        double y = service.getCoordinate("56.1").getResult();
        Point a = new Point("a", x,y);
        x = service.getCoordinate("586").getResult();
        y = service.getCoordinate("1").getResult();
        Point b = new Point("b",x, y);
        Point distance = service.compareDistance(a, b).getResult();
        print.echoResult(distance.toString());
    }
}
