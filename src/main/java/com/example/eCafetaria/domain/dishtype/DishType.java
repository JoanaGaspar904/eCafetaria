package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.domain.dishtype.exceptions.NoSpecialCharacters;
import com.example.eCafetaria.domain.dishtype.exceptions.NotASingleWord;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.*;


@Entity
public class DishType extends Exception{

    @EmbeddedId
    private Acronym acronym;
    @Embedded
    private Description description;
    protected DishType() {
    }

    public DishType(Acronym acronym, Description description) throws NotASingleWord, NoSpecialCharacters{
        setAcronym(acronym);
        setDesignation(description);
    }

    private void setAcronym(Acronym acronym) throws NotASingleWord, NoSpecialCharacters {
        if(acronym.obtainAcronym().contains(" "))
            throw new NotASingleWord();
        if (!acronym.obtainAcronym().toUpperCase().matches("[A-Z]"))
            throw new NoSpecialCharacters();
       this.acronym = acronym;
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