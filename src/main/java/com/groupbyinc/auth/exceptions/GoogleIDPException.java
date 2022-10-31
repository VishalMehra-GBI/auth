package com.groupbyinc.auth.exceptions;

public class GoogleIDPException extends RuntimeException{
    public GoogleIDPException(String message) {
        super(message);
    }
    public GoogleIDPException(String message, Throwable cause) {
        super(message, cause);
    }
}