package com.example.eCafetaria.dishtype.domain.exceptions;

public class NotASingleWord extends RuntimeException {
    public NotASingleWord() {
        super("The Acronym can't contain spaces. Please try another acronym with this consideration.");
    }
}
