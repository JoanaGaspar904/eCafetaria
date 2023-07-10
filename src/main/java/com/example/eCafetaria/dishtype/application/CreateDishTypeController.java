package com.example.eCafetaria.dishtype.application;

import com.example.eCafetaria.dishtype.domain.DishType;
import com.example.eCafetaria.dishtype.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CreateDishTypeController {
    @Autowired
    DishTypeRepository repo;
    @Autowired
    DishTypeMapper mapper;

    public DishType createDishType(final DishTypeAcronymDTO dishTypeAcronymDTO, final DishTypeDescriptionDTO descriptionDTO) {
        final DishType dishType = mapper.toDishType(dishTypeAcronymDTO, descriptionDTO);
        return repo.save(dishType);
    }
    
}
