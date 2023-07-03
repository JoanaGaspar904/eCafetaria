package com.example.eCafetaria.domain.dishtype.exceptions;

public class NotASingleWord extends Exception{
    public NotASingleWord() {
        super("The Acronym can't contain spaces. Please try another acronym with this consideration.");
    }
}
