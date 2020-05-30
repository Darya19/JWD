package com.epam.development.task8;

public class FunctionValue {

   private double x;

    FunctionValue(double x) {
        this.x = x;
    }

    public double getValue(){
        double y;
        if(x >= 3) {
            y = -(Math.pow(x,2)) + 3 * x + 9;
        } else {
            y = 1 / (Math.pow(x, 3) - 6);
        }
        return y;
    }

}
