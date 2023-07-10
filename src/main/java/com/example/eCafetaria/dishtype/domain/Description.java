package com.example.eCafetaria.dishtype.domain;

import com.example.eCafetaria.dishtype.domain.exceptions.InvalidLengthForDescription;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Description {
    @NotNull
    @NotBlank
    @Size(min = 1, max = 2048)
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

    public String getDescription() {
        return description;
    }
}
