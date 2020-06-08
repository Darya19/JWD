package com.epam.shcherbina.main;

import com.epam.shcherbina.console.PrintResult;
import com.epam.shcherbina.entity.Response;
import com.epam.shcherbina.service.StatementService;

import java.util.List;

public class StatementMain {
    public static void main(String[] args) {
        StatementService service = new StatementService();
        PrintResult print = new PrintResult();
        Response<List<Integer>> result = service.createListOfEvenNumbers("1","2", "3","4");
        print.echoResult(result.toString());
        Boolean statement = service.isPerfectNumber(result.getResult()).getResult();
        print.echoResult(statement);

        result = service.createListOfEvenNumbers("3","3", "3","4");
        print.echoResult(result.toString());
        statement =service.isPerfectNumber(result.getResult()).getResult();
        print.echoResult(statement);

        result = service.createListOfEvenNumbers("3","3", "hfvbgdj","4");
        print.echoResult(result.toString());

        Response<Integer> result2 = service.getNumber("6");
        int num = result2.getResult();
        result2 = service.calculateSumOfDividers(num);
        Response<Boolean> statement2 = service.isPerfectNumber(num,result2.getResult());
        print.echoResult(statement2.toString());

        result2 = service.getNumber("1458");
        print.echoResult(result2.toString());

        result2 = service.getNumber("kholk");
        print.echoResult(result2.toString());

        result2 = service.getNumber("18");
        num = result2.getResult();
        result2 = service.calculateSumOfDividers(num);
        statement2 = service.isPerfectNumber(num,result2.getResult());
        print.echoResult(statement2.toString());
    }
}
