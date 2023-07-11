package com.example.eCafetaria.dishtype.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The type Dish type.
 */
@Entity
public class DishType {

    @EmbeddedId
    private Acronym acronym;
    @Embedded
    @Column(nullable = false, unique = false, updatable = true)
    private Description description;

    @Version
    private long version;

    /**
     * Instantiates a new Dish type.
     */
    protected DishType() {
    }


    /**
     * Instantiates a new Dish type.
     *
     * @param acronym     the acronym
     * @param description the description
     */
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

    /**
     * Sets description.
     *
     * @param description the description
     */
    /* This method is public because the user is allowed to change de description
     * wherever he wants.
     */
    public void setDescription(Description description) {
        if (description == null)
            throw new IllegalArgumentException();
        this.description = description;
    }

    /**
     * Gets version.
     *
     * @return the version
     */
    public long getVersion() {
        return version;
    }

    /**
     * Gets acronym.
     *
     * @return the acronym
     */
    public Acronym getAcronym() {
        return acronym;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public Description getDescription() {
        return description;
    }
}