package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.dishtype.Acronym;
import com.example.eCafetaria.domain.dishtype.DishType;
import com.example.eCafetaria.domain.dishtype.exceptions.NoSpecialCharacters;
import com.example.eCafetaria.domain.dishtype.exceptions.NotASingleWord;
import com.example.eCafetaria.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CreateOrUpdateDishTypeController{
    @Autowired
    DishTypeRepository repo;
    @Autowired
    DishTypeMapper mapper;

    public DishTypeDTO createOrUpdateDishType(AcronymDTO acronym, CreateOrUpdateDishTypeDTO dto) throws NotASingleWord, NoSpecialCharacters{
        Optional<DishType> optionalDishType = repo.findById(new Acronym(acronym.acronym));
        DishType dishType;
        if(optionalDishType.isPresent()){
            dishType = mapper.update(optionalDishType.get(), dto);
        } else{
            dishType = mapper.toDishType(acronym, dto);
        }
        DishTypeDTO dishTypeDTO = mapper.toDTO(repo.save(dishType));
        return dishTypeDTO;
    }

}
