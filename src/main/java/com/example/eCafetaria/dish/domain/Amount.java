package com.example.eCafetaria.dish.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Amount {
    int amount;

    protected Amount (){
        //for ORM only
    }

    private Amount (int amount){
        this.amount = amount;
    }

    public static Amount buildAmount (int amount){
        return new Amount(amount);
    }
}
