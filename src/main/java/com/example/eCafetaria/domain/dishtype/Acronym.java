package com.example.eCafetaria.domain.dishtype;

public class Acronym {
    private String acronym;

    public Acronym(String acronym) {
        updateAcronym(acronym);
    }

    private void updateAcronym(String acronym) {
        if(acronym.length() > 3 || acronym.length() < 1)
            throw new StringIndexOutOfBoundsException();
        this.acronym = acronym;
    }
}
