package com.example.eCafetaria.dishtype.api;

import com.example.eCafetaria.dishtype.application.*;
import com.example.eCafetaria.dishtype.domain.Acronym;
import com.example.eCafetaria.dishtype.domain.exceptions.InvalidLengthForDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;


@RestController
@RequestMapping("/dishtype")
public class DishTypeRestController {
    @Autowired
    FindDishTypeController findDishTypeController;
    @Autowired
    CreateOrUpdateDishTypeController createOrUpdateDishTypeController;
   //novo - para poder usar .getversion para acesso ao domain
    @Autowired
    DishTypeMapper dishTypeMapper;

    @GetMapping
    public Iterable<DishTypeDTO> searchAllDishType() {
        Iterable<DishTypeDTO> dishTypeDTOList = new ArrayList<>();
        dishTypeDTOList = findDishTypeController.findAll();
        return dishTypeDTOList;
    }
    //novo -- optional retorna domain e chama mapper para construir dto com response para postman
    @GetMapping("/{acronym}")
    public ResponseEntity<DishTypeDTO> searchByAcronym(@PathVariable("acronym") Acronym acronym){
        var dishTypeChecker = findDishTypeController.findByAcronym(acronym).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "DishType Not Found"));
        return ResponseEntity.ok().eTag(Long.toString(dishTypeChecker.getVersion())).body(dishTypeMapper.toDto(dishTypeChecker));
    }

    @PutMapping("/{Acronym}")
    public DishTypeDTO CreateOrUpdateDishType (@PathVariable("Acronym") AcronymDTO acronym, @RequestBody CreateOrUpdateDishTypeDTO dto) {
        try {
            DishTypeDTO dishTypeDTO = createOrUpdateDishTypeController.createOrUpdateDishType(acronym, dto);
            return dishTypeDTO;

        }catch (InvalidLengthForDescription e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
