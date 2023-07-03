package com.example.eCafetaria.domain.dishtype;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class Acronym implements Serializable {
    private static final long serialVersionUID = -2657775862866472360L;
    private String acronym;

    protected Acronym() {
    }

    public Acronym(String acronym) {
        updateAcronym(acronym);
    }

    private void updateAcronym(String acronym) {
        if(acronym.length() > 3 || acronym.length() < 1)
            throw new StringIndexOutOfBoundsException();
        this.acronym = acronym;
    }

    public String obtainAcronym() {
        return acronym;
    }
}
