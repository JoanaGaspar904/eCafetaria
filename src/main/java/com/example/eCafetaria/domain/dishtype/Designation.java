package com.example.eCafetaria.domain.dishtype;

public class Designation {
    String designation;

    public Designation(String designation) {
        this.designation = designation;
    }

    public void updateDesignation(String designation) {
        new Designation(designation);
    }
}
