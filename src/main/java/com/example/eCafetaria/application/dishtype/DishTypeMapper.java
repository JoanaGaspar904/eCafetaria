package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.dishtype.Acronym;
import com.example.eCafetaria.domain.dishtype.Designation;
import com.example.eCafetaria.domain.dishtype.DishType;
import com.example.eCafetaria.domain.dishtype.exceptions.InvalidLenghtForDesignation;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DishTypeMapper {

    public DishType toDishType(String acronym, CreateOrUpdateDishTypeDTO dto){
        return new DishType(new Acronym(acronym), new Designation(dto.getDesignation()));
    }

    public List<DishTypeDTO> dishTypeDTOList (List<DishType> dishTypeList){
        List<DishTypeDTO> dishTypeDTOList = new ArrayList<>();
        if(!dishTypeList.isEmpty()){
            for (DishType dishType : dishTypeList){
                dishTypeDTOList.add(toDTO(dishType));
            }
        }
        return dishTypeDTOList;
    }

    public DishType update(DishType dishType, CreateOrUpdateDishTypeDTO dto) {
        return new DishType(dishType.getAcronym(), new Designation(dto.designation));
    }
    public DishTypeDTO toDTO(DishType dishType) {
        return new DishTypeDTO(dishType.getAcronym().obtainAcronym(), dishType.getDesignation().getDesignation());
    }
}
