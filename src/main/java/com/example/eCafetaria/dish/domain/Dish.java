package com.example.eCafetaria.dish.domain;

import com.example.eCafetaria.dishtype.domain.DishType;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idDish;

    @Embedded
    Name name;
    @Embedded
    Price price;

    @ManyToOne
    DishType dishType;


    protected Dish(){
        //for ORM only
    }

    public Dish(Name name, Price price, UUID urlName, DishType dishType){
        this.name=name;
        this.price=price;
        this.dishType=dishType;
    }


    public UUID UUIDname (Name name){
     return UUID.fromString(name.name);
    }

}
