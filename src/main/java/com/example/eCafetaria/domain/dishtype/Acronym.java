package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.domain.dishtype.exceptions.NoSpecialCharacters;
import com.example.eCafetaria.domain.dishtype.exceptions.NotASingleWord;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Acronym implements Serializable {
    private static final long serialVersionUID = -192856187882749256L;
    private final String acronym;

    protected Acronym() {
        acronym = null;
    }

    public Acronym(String acronym){
        if(acronym.contains(" "))
            throw new NotASingleWord();
        if (!acronym.toUpperCase().matches("[A-Z]"))
            throw new NoSpecialCharacters();
        if (acronym.length() > 10)
            throw new StringIndexOutOfBoundsException();
        this.acronym = acronym;
    }

    public String obtainAcronym() {
        return acronym;
    }
}
