package com.example.eCafetaria.api.dishtype;

import com.example.eCafetaria.application.dishtype.CreateOrUpdateDishTypeController;
import com.example.eCafetaria.application.dishtype.CreateOrUpdateDishTypeDTO;
import com.example.eCafetaria.application.dishtype.DishTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/dishtype")
public class DishTypeRestController {

    @Autowired
    CreateOrUpdateDishTypeController createOrUpdateDishTypeController;

    @PutMapping("/{Acronym}")
    public DishTypeDTO CreateOrUpdateDishType (@PathVariable("Acronym") String acronym, CreateOrUpdateDishTypeDTO dto){
        DishTypeDTO dishTypeDTO = CreateOrUpdateDishTypeController.update(acronym,dto);
        return dishTypeDTO;
    }

}
