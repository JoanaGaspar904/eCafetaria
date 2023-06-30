package com.example.eCafetaria.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishTypeRepository {
    List<DishType> findAllDishType();
}
 
