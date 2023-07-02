package com.example.eCafetaria.domain.dishtype;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class DishType {

    @Id
    private String acronym;
    private Designation designation;


    protected DishType(){}
    public DishType(String acronym, Designation designation){
        updateAcronym(acronym);
        this.designation=designation;
    }
    private void updateAcronym(String acronym) {
        if(acronym.length() > 3 || acronym.length() < 1)
            throw new StringIndexOutOfBoundsException();
        this.acronym = acronym;
    }
}
