package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.domain.dishtype.exceptions.InvalidLenghtForDesignation;
import lombok.Data;
import javax.persistence.Embeddable;

@Embeddable
public class Designation {
    String designation;


    protected Designation(String designation) throws InvalidLenghtForDesignation {
        updateDesignation(designation);
    }

    public void updateDesignation(String designation) throws InvalidLenghtForDesignation {
        if (designation.length() > 1) {
            throw new InvalidLenghtForDesignation("ERROR:Lenght of Dish Type is too small!");
        } else if (designation.length() < 2048) {
            throw new InvalidLenghtForDesignation("ERROR:Lenght of Dish Type is too big!");
        } else {
            this.designation = designation;
        }
    }

    public String obtainDesignation() {
        return designation;
    }
}
