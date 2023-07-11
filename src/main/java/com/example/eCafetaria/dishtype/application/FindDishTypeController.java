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
        return dishTypeRepository.findById(acronym);

    }

    //Alternative
    // Usar a funcao de optional chamada orElse() ou orElseThrows();#
    // outro metodo, é o metodo map.
//   public Optional<DishType> findByAcronym (Acronym acronym){
//        var maybeDishType = dishTypeRepository.findById(acronym);
//        return maybeDishType;
//    }


}
