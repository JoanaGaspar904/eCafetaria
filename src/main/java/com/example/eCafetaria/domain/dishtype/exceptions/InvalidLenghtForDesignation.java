package com.example.eCafetaria.domain.dishtype.exceptions;

public class InvalidLenghtForDesignation extends Exception{
    public InvalidLenghtForDesignation (){
        super("Invalid Length for 'Description'. Has to be between 1 and 2048 characters!");
    }
    public InvalidLenghtForDesignation(String s) {
        super(s);
    }


}
