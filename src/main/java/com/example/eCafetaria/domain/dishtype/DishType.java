package com.example.eCafetaria.domain.dishtype;

public class DishType {
    private String acronym;
    private DishTypeDesignation designation;

    public DishType(String acronym, DishTypeDesignation designation) {
        setAcronym(acronym);
        this.designation = designation;
    }

    public void setAcronym(String acronym) {
        if(acronym.length() > 3 || acronym.length() < 1)
            throw new StringIndexOutOfBoundsException();
        this.acronym = acronym;
    }
}
