package com.example.eCafetaria.dishtype.application;

import com.example.eCafetaria.dishtype.domain.Acronym;
import com.example.eCafetaria.dishtype.domain.DishType;
import com.example.eCafetaria.dishtype.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CreateOrUpdateDishTypeController{
    @Autowired
    DishTypeRepository repo;
    @Autowired
    DishTypeMapper mapper;

    public DishTypeDTO createOrUpdateDishType(AcronymDTO acronym, CreateOrUpdateDishTypeDTO dto) {
        Optional<DishType> optionalDishType = repo.findById(new Acronym(acronym.acronym));
        DishType dishType;
        if(optionalDishType.isPresent()){
            dishType = mapper.update(optionalDishType.get(), dto);
        } else{
            dishType = mapper.toDishType(acronym, dto);
        }
        DishTypeDTO dishTypeDTO = mapper.toDto(repo.save(dishType));
        return dishTypeDTO;
    }

}
