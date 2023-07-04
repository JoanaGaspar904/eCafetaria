package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.dishtype.Acronym;
import com.example.eCafetaria.domain.dishtype.DishType;
import com.example.eCafetaria.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
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

    public Optional<DishTypeDTO> findByAcronym(Acronym acronym) {
        Optional<DishType> dishTypeChecker= dishTypeRepository.findById(acronym);
        if (dishTypeChecker.isPresent())
            return Optional.of(dishTypeMapper.toDto(dishTypeChecker.get()));
        return Optional.empty();
    }
}
