package com.example.eCafetaria.dishtype.application;

import com.example.eCafetaria.dishtype.domain.Acronym;
import com.example.eCafetaria.dishtype.domain.DishType;
import com.example.eCafetaria.dishtype.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
 * The type Find dish type controller.
 */
@Component
public class FindDishTypeController {
    /**
     * The Dish type repository.
     */
    @Autowired
    DishTypeRepository dishTypeRepository;
    /**
     * The Dish type mapper.
     */
    @Autowired
    DishTypeMapper dishTypeMapper;

    /**
     * Find all iterable.
     *
     * @return the iterable
     */
    public Iterable<DishTypeDTO> findAll() {
        return dishTypeMapper.dishTypeDTOList(dishTypeRepository.findAll());
    }

    /**
     * Find by acronym optional.
     *
     * @param acronym the acronym
     * @return the optional
     */
// novo -- Optional devolve DishType em vez de DishTypeDTO
    // outro -- dishT
    public Optional<DishType> findByAcronym(Acronym acronym) {
        Optional<DishType> dishTypeChecker= dishTypeRepository.findById(acronym);
        if (dishTypeChecker.isPresent())
            return Optional.of(dishTypeChecker.get());
        return Optional.empty();
    }
}
