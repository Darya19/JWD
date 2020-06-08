package com.epam.day1.service;

import com.epam.day1.entity.ErrorCode;
import com.epam.day1.entity.Response;
import com.epam.day1.entity.Status;

public class ResponseHelper {

    public static <T> Response<T> makeOkResponse(T result) {
        return new Response<>(Status.OK, ErrorCode.NONE, result);
    }

    public static <T> Response<T> makeErrorResponse() {
        return new Response<>(Status.OK, ErrorCode.NONE, null);
    }
}
