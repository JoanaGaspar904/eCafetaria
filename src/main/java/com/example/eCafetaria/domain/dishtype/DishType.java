package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.application.dishtype.CreateOrUpdateDishTypeDTO;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class DishType {


    @EmbeddedId
    private Acronym acronym;
    @Embedded
    private Designation designation;


    protected DishType(){}
    public DishType(Acronym acronym, Designation designation){
        this.acronym=acronym;
        updateDesignation(designation);
    }

    public void updateDesignation(Designation designation) {
        this.designation=designation;
    }

    public Acronym getAcronym() {
        return acronym;
    }

    public Designation getDesignation() {
        return designation;
    }
}
