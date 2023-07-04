package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.domain.dishtype.exceptions.InvalidLengthForDescription;

import javax.persistence.Embeddable;

@Embeddable
public class Description {
    private final String description;


    protected Description() {
        this.description = null;
    }

    public Description(String description) {
        if (description.length() < 1 || description.length() > 2048) {
            throw new InvalidLengthForDescription("Error: Description has to be between 1 and 2048 characters!");
        }
        this.description = description;
    }

    public String getDesignation() {
        return description;
    }
}
