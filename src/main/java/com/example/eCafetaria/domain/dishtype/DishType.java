package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.domain.dishtype.exceptions.InvalidLenghtForDescription;

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
        setDescription(description);
    }
    /* This method is private, because don't should be used,
     * Except when we receive the acronym by user
     */

    private void setAcronym(Acronym acronym) {
        this.acronym = new Acronym(acronym.obtainAcronym());

    }
    /* This method is public because the user is allowed to change de description
     * wherever he wants.
     */
    public void setDescription(Description description) {
        if (description.getDesignation().length() < 1 || description.getDesignation().length() > 2048) {
            throw new InvalidLenghtForDescription();
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