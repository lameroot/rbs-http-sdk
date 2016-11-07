package ru.rbs.http.api.exception;


public class InvalidRequestException extends Exception {
    public InvalidRequestException(String error) {
        super(error);
    }
}