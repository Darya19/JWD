package com.epam.shcherbina.console;

import java.util.Map;

public class PrintResult {
    public void echoResult(String value){
        System.out.println(value);
    }

    public void echoResult(int value){
        System.out.println(value);
    }

    public void echoResult(Boolean value){
        System.out.println(value);
    }

    public void echoTableResult(Map<Double, Double> mapOfValues) {
        for (Map.Entry<Double, Double> pair : mapOfValues.entrySet()) {
            double x = pair.getKey();
            double y = pair.getValue();
            System.out.println(x + " | " + y);
        }
    }
}
