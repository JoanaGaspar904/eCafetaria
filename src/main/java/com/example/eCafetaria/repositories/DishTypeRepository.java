package com.example.eCafetaria.repositories;

import com.example.eCafetaria.domain.dishtype.DishType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishTypeRepository {
    DishType save (DishType dishtype);
    List<DishType> findAllDishType();
}
 
