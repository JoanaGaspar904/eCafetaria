package com.example.eCafetaria.repositories;

import com.example.eCafetaria.domain.dishtype.Acronym;
import com.example.eCafetaria.domain.dishtype.DishType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishTypeRepository {
    DishType save (DishType dishtype);
    List<DishType> findAll();
    Optional<DishType> findById(String acronym);


}
 
