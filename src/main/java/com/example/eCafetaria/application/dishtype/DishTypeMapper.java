package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.dishtype.DishType;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DishTypeMapper {

    public DishType toDishType(String acronym, CreateOrUpdateDishTypeDTO dto){
        return new DishType(acronym, dto.designation);
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

    public DishType update(DishType dishType, CreateOrUpdateDishTypeDTO dto){
        dishType.setDesignation(dto.designation);
        return dishType;
    }

    private DishTypeDTO toDTO(DishType dishType) {
        return new DishTypeDTO(dishType.getAcronym(), dishType.getDesignation().getDesignation());
    }
}
