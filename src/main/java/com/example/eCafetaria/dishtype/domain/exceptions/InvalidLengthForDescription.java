package com.example.eCafetaria.dishtype.domain.exceptions;

public class InvalidLengthForDescription extends RuntimeException{
    public InvalidLengthForDescription(){
        super("Invalid Length for 'Description'. Has to be between 1 and 2048 characters!");
    }
    public InvalidLengthForDescription(String s) {
        super(s);
    }


}
