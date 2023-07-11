package com.example.eCafetaria.dish.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Currency;


@Embeddable
public class Price {

    Amount amount;
    Currency currency;

    protected Price(){
        //for ORM only
    }

    private Price (Amount amount, Currency currency){
        this.amount=amount;
        this.currency=currency;
    }

    public static Price buildPrice (Amount amount, Currency currency){
        return new Price(amount, currency);
    }
}
