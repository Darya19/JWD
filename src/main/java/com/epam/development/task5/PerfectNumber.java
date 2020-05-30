package com.epam.development.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectNumber {

    public static void main(String[] args) throws IOException {
      PerfectNumber perfectNumber = new PerfectNumber();
     int number = perfectNumber.getNumber();
     int sumOfDividers = perfectNumber.getSumOfDividers(number);
     System.out.println(perfectNumber.comparisonOfNumberAndSumOfDividers(number, sumOfDividers));
    }

    public int getNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        reader.close();
        return number;
    }

    public int getSumOfDividers(int number) {
        int sumOfDividers = 0;
            for (int i = 1; i < number; i++) {
                if(number % i == 0){
                    sumOfDividers += i;
                }
            }
      return  sumOfDividers;
    }

    public boolean comparisonOfNumberAndSumOfDividers(int number, int sumOfDividers){
    return number == sumOfDividers;
    }
}
