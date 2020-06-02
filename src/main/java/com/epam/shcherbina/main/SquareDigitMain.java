package com.epam.shcherbina.main;

import com.epam.shcherbina.console.SquareDigitConsole;
import com.epam.shcherbina.entity.SquareLastDigit;
import com.epam.shcherbina.exception.InvalidNumberException;
import com.epam.shcherbina.parser.NumberParser;
import com.epam.shcherbina.service.LastDigitService;

public class SquareDigitMain {

    public static void main(String[] args) throws InvalidNumberException {
        SquareLastDigit number = new SquareLastDigit("111");
        NumberParser parser = new NumberParser();
        LastDigitService lastDigit = new LastDigitService();
        SquareDigitConsole console = new SquareDigitConsole();
        console.echoSquareDigit(lastDigit.getSquareOfLastDigit(lastDigit.getLastDigit(parser.numberParser(number.getNumber()))));


    }
}
