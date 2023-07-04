package com.example.eCafetaria.domain.dishtype.exceptions;

public class NoSpecialCharacters extends RuntimeException {
    public NoSpecialCharacters() {
        super("The Acronym can't contain special characters, e.g. ', !, ?. Please try another acronym with this consideration.");
    }
}