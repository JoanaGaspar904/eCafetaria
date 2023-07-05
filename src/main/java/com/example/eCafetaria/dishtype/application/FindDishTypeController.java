package com.example.eCafetaria.dishtype.application;

import com.example.eCafetaria.dishtype.domain.Acronym;
import com.example.eCafetaria.dishtype.domain.DishType;
import com.example.eCafetaria.dishtype.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class FindDishTypeController {
    @Autowired
    DishTypeRepository dishTypeRepository;
    @Autowired
    DishTypeMapper dishTypeMapper;

    public Iterable<DishTypeDTO> findAll() {
        return dishTypeMapper.dishTypeDTOList(dishTypeRepository.findAll());
    }
    // novo -- Optional devolve DishType em vez de DishTypeDTO
    // outro -- dishT
    public Optional<DishType> findByAcronym(Acronym acronym) {
        Optional<DishType> dishTypeChecker= dishTypeRepository.findById(acronym);
        if (dishTypeChecker.isPresent())
            return Optional.of(dishTypeChecker.get());
        return Optional.empty();
    }
}
