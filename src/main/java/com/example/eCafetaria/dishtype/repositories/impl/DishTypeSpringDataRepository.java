package com.example.eCafetaria.dishtype.repositories.impl;

import com.example.eCafetaria.dishtype.domain.Acronym;
import com.example.eCafetaria.dishtype.domain.DishType;
import com.example.eCafetaria.dishtype.repositories.DishTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("SpringData")
public interface DishTypeSpringDataRepository extends DishTypeRepository, CrudRepository<DishType, Acronym> {
}
