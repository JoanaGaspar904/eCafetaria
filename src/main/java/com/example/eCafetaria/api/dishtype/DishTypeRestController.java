package com.example.eCafetaria.api.dishtype;

import com.example.eCafetaria.application.dishtype.FindDishTypeController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;


public class DishTypeRestController {
    @Autowired
    FindDishTypeController findDishTypeController;

    public List<CreateOrUpdateDishTypeDTO> searchAllDishType() {
        List<CreateOrUpdateDishTypeDTO> dishTypeDTOList = new ArrayList<>();
        dishTypeDTOList = findDishTypeController.findAllDishType();
        return dishTypeDTOList;
    }
}
