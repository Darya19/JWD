package com.epam.development.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FirstTask {
    public static void main(String[] args) throws IOException {
        FirstTask firstTask = new FirstTask();
        int lastDigitOfNumber = firstTask.getLastDigitOfNumber();
        System.out.println(firstTask.getSquareOfLastDigit(lastDigitOfNumber));

    }

    public int getLastDigitOfNumber() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        reader.close();
        return number % 10;
    }

    public int getSquareOfLastDigit(int digit) {
        int squareOfLastDigit  = (int) Math.pow(digit, 2);
        return squareOfLastDigit % 10;
    }
}
