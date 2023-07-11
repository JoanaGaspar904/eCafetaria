package com.example.eCafetaria.dishtype.application;

import com.example.eCafetaria.dishtype.domain.Acronym;
import com.example.eCafetaria.dishtype.domain.DishType;
import com.example.eCafetaria.dishtype.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * The type Update dish type controller.
 */
@Component
public class UpdateDishTypeController {
    /**
     * The Mapper.
     */
    @Autowired
    DishTypeMapper mapper;
    /**
     * The Repo.
     */
    @Autowired
    DishTypeRepository repo;


    /**
     * Update dish type dish type.
     *
     * @param versionFromIfMatchHeader the version from if match header
     * @param acronym                  the acronym
     * @param descriptionDto           the description dto
     * @return the dish type
     */
    public DishType updateDishType(Long versionFromIfMatchHeader, DishTypeAcronymDTO acronym, DishTypeDescriptionDTO descriptionDto) {
        Optional<DishType> optionalDishType = repo.findById(new Acronym(acronym.acronym));
        return mapper.update(optionalDishType.get(), descriptionDto);
    }
}
