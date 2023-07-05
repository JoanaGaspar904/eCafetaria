package com.example.eCafetaria.dishtype.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class DishType {

    @EmbeddedId
    private Acronym acronym;
    @Embedded
    private Description description;

    @Version
    private long version;

    protected DishType() {
    }



    public DishType(Acronym acronym, Description description){
        setAcronym(acronym);
        setDescription(description);
    }
    /* This method is private, because don't should be used,
     * Except when we receive the acronym by user
     */

    private void setAcronym(Acronym acronym) {
        if (acronym == null)
            throw new IllegalArgumentException();
       this.acronym = acronym;
    }
    /* This method is public because the user is allowed to change de description
     * wherever he wants.
     */
    public void setDescription(Description description) {
        if (description == null)
            throw new IllegalArgumentException();
        this.description = description;
    }

    public long getVersion() {
        return version;
    }
    public Acronym getAcronym() {
        return acronym;
    }

    public Description getDescription() {
        return description;
    }
}