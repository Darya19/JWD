package com.epam.shcherbina.parser;

import com.epam.shcherbina.entity.Response;
import com.epam.shcherbina.entity.Status;

public class TimeParser {

    public Response<Integer> parseMonthToInt(String date){
        int month = 0;
        switch (date) {
            case "january" :
                month = 1;
                break;
            case "february" :
                month = 2;
                break;
            case "march" :
                month = 3;
                break;
            case "april" :
                month = 4;
                break;
            case "may" :
                month = 5;
                break;
            case "june" :
                month = 6;
                break;
            case "july" :
                month = 7;
                break;
            case "august" :
                month = 8;
                break;
            case "september" :
                month = 9;
                break;
            case "october" :
                month = 10;
                break;
            case "november" :
                month =11;
                break;
            case "december" :
                month = 12;
                break;
            default: return new Response<Integer>(Status.ERROR, "Invalid number", null);
        }
        return new Response<Integer>(Status.OK, "none", month);
    }
}
