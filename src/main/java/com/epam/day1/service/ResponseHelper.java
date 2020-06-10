package com.epam.day1.service;

import com.epam.day1.response.ErrorCode;
import com.epam.day1.response.Response;
import com.epam.day1.response.Status;

public class ResponseHelper {

    public static <T> Response<T> makeOkResponse(T result) {
        return new Response<>(Status.OK, ErrorCode.NONE, result);
    }

    public static <T> Response<T> makeErrorResponse(ErrorCode errorCode) {
        return new Response<>(Status.ERROR, errorCode, null);
    }
}
