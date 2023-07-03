package com.example.eCafetaria.domain.dishtype;

import javax.persistence.Embeddable;

@Embeddable
public class Description {
    private final String designation;


    protected Description() {
        this.designation = null;
    }

    public Description(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
