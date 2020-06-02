package com.epam.shcherbina.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimesOfDay {

    private  final int secondsInMinute = 60;
    private  final int secondsInHour = 3600;

    public static void main(String[] args) throws IOException, InvalidNumberOfSecondsException {
        TimesOfDay timesOfDay = new TimesOfDay();
        timesOfDay.getNumberOfHoursMinutesSeconds();
    }

    public int getNumberOfSeconds() throws IOException, InvalidNumberOfSecondsException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfSeconds = Integer.parseInt(reader.readLine());
        if(numberOfSeconds < 1 || numberOfSeconds > 86400) {
            throw new InvalidNumberOfSecondsException("Invalid number");
        }
        reader.close();
        return numberOfSeconds;
    }

    public void getNumberOfHoursMinutesSeconds() throws IOException, InvalidNumberOfSecondsException {
        TimesOfDay timesOfDay = new TimesOfDay();
        int number = timesOfDay.getNumberOfSeconds();
        int numberOfHours = number / secondsInHour;
        int numberOfMinutes = number % secondsInHour / secondsInMinute;
        int numberOfSeconds = number % secondsInHour % secondsInMinute;
        System.out.println(numberOfHours + " hours " + numberOfMinutes + " minutes " + numberOfSeconds + " seconds ");
    }
}
