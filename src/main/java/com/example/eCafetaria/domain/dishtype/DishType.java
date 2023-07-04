package com.example.eCafetaria.domain.dishtype;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class DishType {

    @EmbeddedId
    private Acronym acronym;
    @Embedded
    private Description description;


    protected DishType() {
    }

    public DishType(Acronym acronym, Description description) {
        setAcronym(acronym);
        setDesignation(description);
    }

    private void setAcronym(Acronym acronym) {
        this.acronym = new Acronym(acronym.obtainAcronym());

    }

    public void setDesignation(Description description) {
        if (description.getDesignation().length() < 1 || description.getDesignation().length() > 2048) {
            //   throw new InvalidLenghtForDesignation("Error: Description has to be between 1 and 2048 characters!");
        }
        this.description = new Description(description.getDesignation());
    }


    public Acronym getAcronym() {
        return acronym;
    }

    public Description getDesignation() {
        return description;
    }
}