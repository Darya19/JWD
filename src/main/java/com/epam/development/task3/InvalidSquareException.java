package com.epam.development.task3;

public class InvalidSquareException extends Throwable {

    public InvalidSquareException(String invalid_number) {
    }

    public InvalidSquareException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSquareException(Throwable cause) {
        super(cause);
    }

    public InvalidSquareException() {
    }
}
