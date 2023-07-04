package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.dishtype.Acronym;
import com.example.eCafetaria.domain.dishtype.Description;
import com.example.eCafetaria.domain.dishtype.DishType;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DishTypeMapper {

    public DishType toDishType(AcronymDTO acronym, CreateOrUpdateDishTypeDTO dto)throws NotASingleWord, NoSpecialCharacters{
        return new DishType(new Acronym(acronym.acronym), new Description(dto.getDesignation()));

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
       dishType.setDescription(new Description(dto.getDesignation()));
       return dishType;
    }
    public DishTypeDTO toDTO(DishType dishType) {
        return new DishTypeDTO(dishType.getAcronym().obtainAcronym(), dishType.getDesignation().getDesignation());
    }
}
