package com.epam.day1.parser;

import com.epam.day1.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public class ListOfNumbersParser {

    public List<Integer> parseToIntList(String... value) throws CustomException {
        List<Integer> listOfNumbers = new ArrayList<>();
        int number = 0;
        try {
            for (int i = 0; i < 4; i++) {
                number = Integer.parseInt(value[i]);
                listOfNumbers.add(number);
            }
            return listOfNumbers;
        } catch (NumberFormatException e) {
            throw new CustomException("Parsing issues", e);
        }
    }
}
