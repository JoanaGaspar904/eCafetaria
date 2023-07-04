package com.example.eCafetaria.api.dishtype;

import com.example.eCafetaria.application.dishtype.CreateOrUpdateDishTypeController;
import com.example.eCafetaria.application.dishtype.CreateOrUpdateDishTypeDTO;
import com.example.eCafetaria.application.dishtype.DishTypeDTO;
import com.example.eCafetaria.domain.dishtype.Acronym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.eCafetaria.application.dishtype.FindDishTypeController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishtype")
public class DishTypeRestController {
    @Autowired
    FindDishTypeController findDishTypeController;
    @Autowired
    CreateOrUpdateDishTypeController createOrUpdateDishTypeController;

    @GetMapping
    public List<DishTypeDTO> searchAllDishType() {
        List<DishTypeDTO> dishTypeDTOList = new ArrayList<>();
        dishTypeDTOList = findDishTypeController.findAll();
        return dishTypeDTOList;
    }

    @GetMapping("/{acronym}")
    public DishTypeDTO searchByAcronym(@PathVariable("acronym") Acronym acronym){
        Optional<DishTypeDTO> dishTypeChecker = findDishTypeController.findByAcronym(acronym);
        if(dishTypeChecker.isPresent())
            return dishTypeChecker.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Autowired
    CreateOrUpdateDishTypeController createOrUpdateDishTypeController;
    @PutMapping("/{Acronym}")
    public DishTypeDTO CreateOrUpdateDishType (@PathVariable("Acronym") AcronymDTO acronym, @RequestBody CreateOrUpdateDishTypeDTO dto) {
        try {
            DishTypeDTO dishTypeDTO = createOrUpdateDishTypeController.createOrUpdateDishType(acronym, dto);
            return dishTypeDTO;
        }catch (InvalidLenghtForDescription e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
