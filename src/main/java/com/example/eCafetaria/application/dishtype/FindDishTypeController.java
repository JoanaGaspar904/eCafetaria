package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FindDishTypeController {
    @Autowired
    DishTypeMapper dishTypeMapper;

    public List<CreateOrUpdateDishTypeDTO> findAllDishType() {
        return dishTypeMapper.dishTypeListToDTOList(DishTypeRepository.findAllDishType());
    }
}
