package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.dishtype.DishType;
import java.util.ArrayList;
import java.util.List;

public class DishTypeMapper {

    public List<CreateOrUpdateDishTypeDTO> dishTypeDTOList(List<DishType> dishTypeList) {
        List<CreateOrUpdateDishTypeDTO> dishTypeDTOList = new ArrayList<>();
        if (!dishTypeList.isEmpty()) {
            for (DishType dishType : dishTypeDTOList) {
                dishTypeDTOList.add(dishTypeToDTO(dishType));
            }
        }
        return dishTypeDTOList;
    }
}
