package com.epam.development.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondTask {
    public static void main(String[] args) throws IOException {
        SecondTask secondTask = new SecondTask();
        secondTask.getDate();
    }
    public int getDate() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(reader.readLine());
        int year = Integer.parseInt(reader.readLine());
       return month;
    }


}
