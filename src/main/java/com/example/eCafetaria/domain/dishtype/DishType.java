package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.domain.dishtype.exceptions.InvalidLenghtForDesignation;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class DishType {

    @EmbeddedId
    private Acronym acronym;
    @Embedded
    private Designation designation;


    protected DishType(){}
    public DishType(Acronym acronym, Designation designation){
        this.acronym=acronym;
        updateDesignation(designation);
    }

    public void updateDesignation(Designation designation) {
        this.designation=designation;
    }

    public Acronym getAcronym() {
        return acronym;
    }

    public Designation getDesignation() {
        return designation;
    }

    private void setAcronym(Acronym acronym) {
        this.acronym = acronym;
    }

    private void setDesignation(Designation designation) {
        this.designation = designation;
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
}
