package com.example.eCafetaria.dishtype.application;

import com.example.eCafetaria.dishtype.domain.Acronym;
import com.example.eCafetaria.dishtype.domain.DishType;
import com.example.eCafetaria.dishtype.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateDishType {
    @Autowired
    DishTypeMapper mapper;
    @Autowired
    DishTypeRepository repo;


    public DishType updateDishType(Long versionFromIfMatchHeader, AcronymDTO acronym, DishTypeDescriptionDTO descriptionDto) {
        Optional<DishType> optionalDishType = repo.findById(new Acronym(acronym.acronym));
        return mapper.update(optionalDishType.get(), descriptionDto);
    }
}
