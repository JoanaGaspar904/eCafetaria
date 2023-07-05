package com.example.eCafetaria.dishtype.repositories;

import com.example.eCafetaria.dishtype.domain.Acronym;
import com.example.eCafetaria.dishtype.domain.DishType;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DishTypeRepository {
    DishType save (DishType dishtype);
    List<DishType> findAll();
    Optional<DishType> findById(Acronym acronym);


}
 
