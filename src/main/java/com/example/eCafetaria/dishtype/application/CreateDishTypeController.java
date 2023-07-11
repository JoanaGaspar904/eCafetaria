package com.example.eCafetaria.dishtype.application;

import com.example.eCafetaria.dishtype.domain.DishType;
import com.example.eCafetaria.dishtype.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * The type Create dish type controller.
 */
@Component
public class CreateDishTypeController {
    /**
     * The Repo.
     */
    @Autowired
    DishTypeRepository repo;
    /**
     * The Mapper.
     */
    @Autowired
    DishTypeMapper mapper;

    /**
     * Create dish type dish type.
     *
     * @param dishTypeAcronymDTO the dish type acronym dto
     * @param descriptionDTO     the description dto
     * @return the dish type
     */
    public DishType createDishType(final DishTypeAcronymDTO dishTypeAcronymDTO, final DishTypeDescriptionDTO descriptionDTO) {
        final DishType dishType = mapper.toDishType(dishTypeAcronymDTO, descriptionDTO);
        return repo.save(dishType);
    }
    
}
