package com.xask.exceptions;

public class NonAuthenticatedUserException extends Exception{
    public NonAuthenticatedUserException(String message) {
        super(message);
    }
}
