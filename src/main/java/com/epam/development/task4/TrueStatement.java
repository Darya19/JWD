package com.epam.development.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrueStatement {

    public static void main(String[] args) throws IOException {
        TrueStatement trueStatement = new TrueStatement();
        System.out.println((trueStatement.getEvenNumberedList().size() >= 2) ? "true" : "false");
    }

    public List<Integer> getNumbers() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> listOfNumbers = new ArrayList<>();
        int count = 0;
        while (count < 4) {
            int number = Integer.parseInt(reader.readLine());
            listOfNumbers.add(number);
            count++;
        }
        reader.close();
        return listOfNumbers;
    }

    public List<Integer> getEvenNumberedList() throws IOException {
      return   getNumbers().stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }
}
