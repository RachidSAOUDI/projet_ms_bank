package com.example.customerservice.exceptions;

public class EmailAlreadyExistException extends Exception {
    public EmailAlreadyExistException(String message){
        super(message);
    }
}
