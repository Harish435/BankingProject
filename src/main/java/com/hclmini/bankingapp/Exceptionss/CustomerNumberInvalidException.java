package com.hclmini.bankingapp.Exceptionss;

public class CustomerNumberInvalidException extends RuntimeException{
    public CustomerNumberInvalidException() {
    }

    public CustomerNumberInvalidException(String message) {
        super(message);
    }

    public CustomerNumberInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
