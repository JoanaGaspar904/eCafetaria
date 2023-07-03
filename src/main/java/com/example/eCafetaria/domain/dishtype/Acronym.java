package com.example.eCafetaria.domain.dishtype;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Acronym implements Serializable {
    private final String acronym;

    protected Acronym() {
        acronym = null;
    }

    public Acronym(String acronym) {
        this.acronym = acronym;
    }

    public String obtainAcronym() {
        return acronym;
    }
}
