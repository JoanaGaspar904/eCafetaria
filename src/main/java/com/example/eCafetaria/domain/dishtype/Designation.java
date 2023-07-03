package com.example.eCafetaria.domain.dishtype;

import javax.persistence.Embeddable;

@Embeddable
public class Designation {
    private final String designation;


    protected Designation() {
        this.designation = null;
    }

    public Designation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
