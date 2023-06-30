package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.repositories.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FindDishTypeController {
    @Autowired
    DishTypeRepository dishTypeRepository;
    @Autowired
    DishTypeMapper dishTypeMapper;

    public List<DishTypeDTO> findAll() {
        return dishTypeMapper.dishTypeListToDTOList(dishTypeRepository.findAll());
    }
}
