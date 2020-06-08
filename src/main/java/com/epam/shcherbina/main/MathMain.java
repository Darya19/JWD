package com.epam.shcherbina.main;

import com.epam.shcherbina.console.PrintResult;
import com.epam.shcherbina.entity.ResultResponse;
import com.epam.shcherbina.service.MathService;

public class MathMain {

    public static void main(String[] args)  {
       MathService service = new MathService();
       PrintResult result = new PrintResult();
           ResultResponse<Integer> mathResult  = service.calculateLastDigit("54");
           mathResult = service.calculateSquareOfLastDigit(mathResult.getResult());
           result.echoResult(mathResult.toString());

        mathResult = service.calculateLastDigit("UIJNIJ");
           result.echoResult(mathResult.toString());
    }
}
