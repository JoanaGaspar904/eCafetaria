package com.example.eCafetaria.dishtype.domain;

import com.example.eCafetaria.dishtype.domain.exceptions.InvalidLengthForDescription;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The type Description.
 */
@Embeddable
public class Description {
    @NotNull
    @NotBlank
    @Size(min = 1, max = 2048)
    private final String description;


    /**
     * Instantiates a new Description.
     */
    protected Description() {
        this.description = null;
    }

    /**
     * Instantiates a new Description.
     *
     * @param description the description
     */
    public Description(String description) {
        if (description.length() < 1 || description.length() > 2048) {
            throw new InvalidLengthForDescription("Error: Description has to be between 1 and 2048 characters!");
        }
        this.description = description;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
