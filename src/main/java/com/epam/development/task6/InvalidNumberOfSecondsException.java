package com.epam.development.task6;

public class InvalidNumberOfSecondsException extends Throwable {

    public InvalidNumberOfSecondsException() {
    }

    public InvalidNumberOfSecondsException(String message) {
        super(message);
    }

    public InvalidNumberOfSecondsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberOfSecondsException(Throwable cause) {
        super(cause);
    }
}
