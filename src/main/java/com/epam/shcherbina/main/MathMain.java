package com.epam.shcherbina.main;

import com.epam.shcherbina.console.ShowResult;
import com.epam.shcherbina.service.MathService;

public class MathMain {

    public static void main(String[] args)  {
       MathService service = new MathService();
       ShowResult result = new ShowResult();
       result.echoResult(service.getSquareOfLastDigit("-548"));
        result.echoResult(service.getSquareOfLastDigit(-548));
        result.echoResult(service.getSquareOfLastDigit("vhgvuhb"));
        result.echoResult(service.getSquareOfLastDigit(1211));
    }
}
