package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.dishtype.DishType;
import java.util.ArrayList;
import java.util.List;

public class DishTypeMapper {

    public List<DishTypeDTO> dishTypeListToDTOList(List<DishType> dishTypeList) {
        List<DishTypeDTO> dishTypeDTOList = new ArrayList<>();
        if (!dishTypeList.isEmpty()) {
            for (DishType dishType : dishTypeList) {
                dishTypeDTOList.add(dishTypeDTO(dishType));
            }
        }
        return dishTypeDTOList;
    }

    private DishTypeDTO dishTypeDTO(DishType dishType) {
        return new DishTypeDTO(dishType.getAcronym(), dishType.getDesignation().getDesignation());
    }
}
