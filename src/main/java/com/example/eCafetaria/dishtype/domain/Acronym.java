package com.example.eCafetaria.dishtype.domain;

import com.example.eCafetaria.dishtype.domain.exceptions.NoSpecialCharacters;
import com.example.eCafetaria.dishtype.domain.exceptions.NotASingleWord;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class Acronym implements Serializable {
    private static final long serialVersionUID = -192856187882749256L;
    @Size(min = 1, max = 10)
    private final String acronym;

    protected Acronym() {
        acronym = null;
    }

    public Acronym(String acronym){
        if(acronym.contains(" "))
            throw new NotASingleWord();
        if (!(acronym.toUpperCase().matches("^[A-Z]*$")))
            throw new NoSpecialCharacters();
        if (acronym.length() > 10)
            throw new StringIndexOutOfBoundsException();
        this.acronym = acronym;
    }

    public String obtainAcronym() {
        return acronym;
    }
}
