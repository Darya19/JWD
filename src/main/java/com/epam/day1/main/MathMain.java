package com.epam.day1.main;

import com.epam.day1.console.PrintResult;
import com.epam.day1.entity.Response;
import com.epam.day1.service.MathService;

public class MathMain {

    public static void main(String[] args)  {
       MathService service = new MathService();
       PrintResult result = new PrintResult();
           Response<Integer> mathResult  = service.calculateLastDigit("54");
           mathResult = service.calculateLastDigitOfSquare(mathResult.getResult());
           result.echoResult(mathResult.toString());

        mathResult = service.calculateLastDigit("UIJNIJ");
           result.echoResult(mathResult.toString());
    }
}
