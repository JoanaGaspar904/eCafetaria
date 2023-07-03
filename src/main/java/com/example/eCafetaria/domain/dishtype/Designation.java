package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.domain.dishtype.exceptions.InvalidLenghtForDesignation;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
public class Designation {
    String designation;


    public Designation() {
    }

    public Designation(String designation) {
        updateDesignation(designation);
    }

    private void updateDesignation(String designation){
        try {
            if (designation.length() < 1 || designation.length() > 2048) {
                throw new InvalidLenghtForDesignation("Error: Designation has to be between 1 and 2048 characters!");
            }
                this.designation = designation;

        } catch (InvalidLenghtForDesignation e) {
            System.out.println(e.getMessage());
        }
    }

    public String obtainDesignation() {
        return designation;
    }
}
