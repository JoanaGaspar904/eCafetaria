package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CreateOrUpdateDishTypeController {
    @Autowired
    DishTypeRepository repo;
    @Autowired
    DishTypeMapper mapper;

}
