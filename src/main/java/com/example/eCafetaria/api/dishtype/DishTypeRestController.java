package com.example.eCafetaria.api.dishtype;

import com.example.eCafetaria.application.dishtype.CreateOrUpdateDishTypeController;
import com.example.eCafetaria.application.dishtype.CreateOrUpdateDishTypeDTO;
import com.example.eCafetaria.application.dishtype.DishTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.eCafetaria.application.dishtype.FindDishTypeController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dishtype")
public class DishTypeRestController {
    @Autowired
    FindDishTypeController findDishTypeController;

    public List<DishTypeDTO> searchAllDishType() {
        List<DishTypeDTO> dishTypeDTOList = new ArrayList<>();
        dishTypeDTOList = findDishTypeController.findAll();
        return dishTypeDTOList;
    }

    @Autowired
    CreateOrUpdateDishTypeController createOrUpdateDishTypeController;

    @PutMapping("/{Acronym}")
    public DishTypeDTO CreateOrUpdateDishType (@PathVariable(acronym = "Acronym") String acronym, @RequestBody CreateOrUpdateDishTypeDTO dto){
        DishTypeDTO dishTypeDTO = CreateOrUpdateDishTypeController.createOrUpdateDishType(acronym,dto);
        return dishTypeDTO;
    }

}
