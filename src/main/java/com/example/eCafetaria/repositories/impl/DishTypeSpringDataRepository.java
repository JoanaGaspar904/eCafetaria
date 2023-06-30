package com.example.eCafetaria.repositories.impl;

import com.example.eCafetaria.domain.dishtype.DishType;
import com.example.eCafetaria.repositories.DishTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("SpringData")
public interface DishTypeSpringDataRepository extends DishTypeRepository, CrudRepository<DishType, String> {
}
