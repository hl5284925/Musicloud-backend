package com.example.musicloudbackend.exceptions;


public class InformationNotFoundException extends RuntimeException{

    public InformationNotFoundException(String message){
        super(message);
    }
}
