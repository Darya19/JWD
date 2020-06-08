package com.epam.day1.main;

import com.epam.day1.console.PrintResult;
import com.epam.day1.entity.Point;
import com.epam.day1.service.PointService;

public class PointMain {
    public static void main(String[] args) {
        PointService service = new PointService();
        PrintResult print = new PrintResult();
        double x = service.checkCoordinate("56.1").getResult();
        double y = service.checkCoordinate("56.1").getResult();
        Point a = new Point("a", x,y);
        x = service.checkCoordinate("56.1").getResult();
        y = service.checkCoordinate("56.1").getResult();
        Point b = new Point("b",x, y);
        Point distance = service.compareDistance(a, b).getResult();
        print.echoResult(distance.toString());
    }
}
