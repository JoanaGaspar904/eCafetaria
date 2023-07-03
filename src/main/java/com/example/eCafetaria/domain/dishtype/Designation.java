package com.example.eCafetaria.domain.dishtype;

import javax.persistence.Embeddable;

@Embeddable
public class Designation {
    String designation;

    protected Designation() {
    }

    public Designation(String designation) {
        this.designation = designation;
    }

    public void updateDesignation(String designation) {
        new Designation(designation);
    }

    public String obtainDesignation() {
        return designation;
    }
}
