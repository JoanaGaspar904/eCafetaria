package com.example.eCafetaria.api.dishtype;

import com.example.eCafetaria.application.dishtype.CreateOrUpdateDishTypeController;
import com.example.eCafetaria.application.dishtype.CreateOrUpdateDishTypeDTO;
import com.example.eCafetaria.application.dishtype.DishTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.eCafetaria.application.dishtype.FindDishTypeController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/dishtype")
public class DishTypeRestController {
    @Autowired
    FindDishTypeController findDishTypeController;

    public List<CreateOrUpdateDishTypeDTO> searchAllDishType() {
        List<CreateOrUpdateDishTypeDTO> dishTypeDTOList = new ArrayList<>();
        dishTypeDTOList = findDishTypeController.findAllDishType();
        return dishTypeDTOList;
    }

    @Autowired
    CreateOrUpdateDishTypeController createOrUpdateDishTypeController;

    @PutMapping("/{Acronym}")
    public DishTypeDTO CreateOrUpdateDishType (@PathVariable("Acronym") String acronym, CreateOrUpdateDishTypeDTO dto){
        DishTypeDTO dishTypeDTO = CreateOrUpdateDishTypeController.update(acronym,dto);
        return dishTypeDTO;
    }

}
