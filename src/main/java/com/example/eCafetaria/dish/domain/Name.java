package com.example.eCafetaria.dish.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Name {
    String name;

    protected Name(){
        //for ORM only
    }

    private Name (String name){
        this.name=name;
    }

    public static Name buildName (String name){
        return new Name(name);
    }


}
