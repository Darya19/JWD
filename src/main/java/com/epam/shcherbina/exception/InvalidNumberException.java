package com.epam.shcherbina.exception;

public class InvalidNumberException extends Exception {
    public InvalidNumberException() {
    }

    public InvalidNumberException(String message) {
        super(message);
    }

    public InvalidNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberException(Throwable cause) {
        super(cause);
    }
}
