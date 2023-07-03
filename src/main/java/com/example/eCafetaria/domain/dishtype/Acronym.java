package com.example.eCafetaria.domain.dishtype;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Acronym implements Serializable {
    private String acronym;

    protected Acronym() {
    }

    public Acronym(String acronym) {
        updateAcronym(acronym);
    }

    private void updateAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String obtainAcronym() {
        return acronym;
    }
}
