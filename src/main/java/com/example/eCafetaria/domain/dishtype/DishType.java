package com.example.eCafetaria.domain.dishtype;
import com.example.eCafetaria.domain.DishTypeDesignation;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class DishType {

    @Id
    private String acronym;
    private DishTypeDesignation designation;


    protected DishType(){}
    private DishType(String acronym, DishTypeDesignation designation){
        setAcronym(acronym);
        this.designation=designation;
    }
    public void setAcronym(String acronym) {
        if(acronym.length() > 3 || acronym.length() < 1)
            throw new StringIndexOutOfBoundsException();
        this.acronym = acronym;
    }
}
