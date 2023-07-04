package com.example.eCafetaria.domain.dishtype.exceptions;

public class InvalidLenghtForDescription extends Exception{
    public InvalidLenghtForDescription(){
        super("Invalid Length for 'Description'. Has to be between 1 and 2048 characters!");
    }
    public InvalidLenghtForDescription(String s) {
        super(s);
    }


}
