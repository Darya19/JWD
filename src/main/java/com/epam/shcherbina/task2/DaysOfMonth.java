package com.epam.shcherbina.task2;

import java.time.LocalDate;

public class DaysOfMonth {

    private int month;
    private int year;

    public DaysOfMonth(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public void getNumberOfDays() {
        LocalDate date = LocalDate.of(year, month, 1);
        System.out.println(date.lengthOfMonth());
    }


}
