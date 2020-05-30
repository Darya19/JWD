package com.epam.development.task10;

public class Function {

   private double a, b;
   private double h;

    private Function(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public void getValue(){
        double x;
        double y;
        System.out.println(" x   |   y" );
        for (x = a; x <= b;) {
         y = Math.tan(x);
            System.out.println(x + " | " + y);
            x = x + h;
        }

    }
}
