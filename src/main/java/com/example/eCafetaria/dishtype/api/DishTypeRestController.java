package com.example.eCafetaria.dishtype.api;

import com.example.eCafetaria.dishtype.application.*;
import com.example.eCafetaria.dishtype.domain.Acronym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;


@RestController
@RequestMapping("/dishtype")
public class DishTypeRestController {
    @Autowired
    FindDishTypeController findDishTypeController;
    @Autowired
    CreateDishTypeController createDishTypeController;
    //novo - para poder usar .getversion para acesso ao domain
    @Autowired
    DishTypeMapper dishTypeMapper;
    @Autowired
    UpdateDishType updateDishType;

    @GetMapping
    public Iterable<DishTypeDTO> searchAllDishType() {
        Iterable<DishTypeDTO> dishTypeDTOList = new ArrayList<>();
        dishTypeDTOList = findDishTypeController.findAll();
        return dishTypeDTOList;
    }

    //novo -- optional retorna domain e chama mapper para construir dto com response para postman
    @GetMapping("/{acronym}")
    public ResponseEntity<DishTypeDTO> searchByAcronym(@PathVariable("acronym") Acronym acronym) {
        var dishTypeChecker = findDishTypeController.findByAcronym(acronym).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "DishType Not Found"));
        return ResponseEntity.ok().eTag(Long.toString(dishTypeChecker.getVersion())).body(dishTypeMapper.toDto(dishTypeChecker));
    }

    @PutMapping("/{Acronym}")
    public ResponseEntity<DishTypeDTO> CreateOrUpdateDishType(final WebRequest request, @PathVariable("Acronym") AcronymDTO acronym, @RequestBody DishTypeDescriptionDTO descriptionDto) {
        final String ifMatchValue = request.getHeader("if-Match");
        if (ifMatchValue == null || ifMatchValue.isEmpty()) {
            final var dishType = createDishTypeController.createDishType(acronym, descriptionDto);
            final var dishTypeURI = ServletUriComponentsBuilder.fromCurrentRequestUri().pathSegment(dishType.getAcronym().obtainAcronym()).build().toUri();
            return ResponseEntity.created(dishTypeURI).eTag(Long.toString(dishType.getVersion())).body(dishTypeMapper.toDto(dishType));
        }
        final var dishType = updateDishType.updateDishType(getVersionFromIfMatchHeader(ifMatchValue), acronym, descriptionDto);
        return ResponseEntity.ok().eTag(Long.toString(dishType.getVersion())).body(dishTypeMapper.toDto(dishType));
    }

    private Long getVersionFromIfMatchHeader(final String ifMatchHeader){
        if(ifMatchHeader.startsWith("\"")){
            return Long.parseLong(ifMatchHeader.substring(1, ifMatchHeader.length() -1));
        }
        return Long.parseLong(ifMatchHeader);
    }
}
