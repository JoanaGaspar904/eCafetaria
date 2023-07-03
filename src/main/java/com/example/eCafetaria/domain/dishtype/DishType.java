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


    protected DishType() {
    }

    public DishType(Acronym acronym, Designation designation) {
        setAcronym(acronym);
        setDesignation(designation);
    }

    private void setAcronym(Acronym acronym) {
        new Acronym(acronym.obtainAcronym());
    }

    private void setDesignation(Designation designation) {
        try {
            if (designation.getDesignation().length() < 1 || designation.getDesignation().length() > 2048) {
                throw new InvalidLenghtForDesignation("Error: Designation has to be between 1 and 2048 characters!");
            }
            new Designation(designation.getDesignation());
        } catch (InvalidLenghtForDesignation e) {
            System.out.println(e.getMessage());
        }
    }

    public Acronym getAcronym() {
        return acronym;
    }

    public Designation getDesignation() {
        return designation;
    }
}
