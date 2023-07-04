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
        setDescription(description);
    }
    /* This method is private, because don't should be used,
     * Except when we receive the acronym by user
     */

    private void setAcronym(Acronym acronym) throws NotASingleWord, NoSpecialCharacters, StringIndexOutOfBoundsException {
        if(acronym.obtainAcronym().contains(" "))
            throw new NotASingleWord();
        if (!acronym.obtainAcronym().toUpperCase().matches("[A-Z]"))
            throw new NoSpecialCharacters();
        if (acronym.obtainAcronym().length() > 10)
            throw new StringIndexOutOfBoundsException();
       this.acronym = acronym;
    }
    /* This method is public because the user is allowed to change de description
     * wherever he wants.
     */
    public void setDescription(Description description) {
        if (description.getDesignation().length() < 1 || description.getDesignation().length() > 2048) {
            throw new InvalidLenghtForDescription("Error: Description has to be between 1 and 2048 characters!");
        }
        this.description = new Description(description.getDesignation());
    }


    public Acronym getAcronym() {
        return acronym;
    }

    public Description getDescription() {
        return description;
    }
}