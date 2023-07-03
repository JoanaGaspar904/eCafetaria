package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.application.dishtype.CreateOrUpdateDishTypeDTO;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DishType {

    @Id
    private String acronym;
    @Embedded
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

    public DishType update(CreateOrUpdateDishTypeDTO dto){
      DishType dishType = new DishType(acronym, dto.getDesignation());
        return dishType;
    }

    public String getAcronym() {
        return acronym;
    }

    public Designation getDesignation() {
        return designation;
    }
}
