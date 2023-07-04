package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.dishtype.Acronym;
import com.example.eCafetaria.domain.dishtype.Description;
import com.example.eCafetaria.domain.dishtype.DishType;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DishTypeMapper {
    public abstract DishTypeDTO toDto(DishType dishType);
    public String acronymToString(Acronym a){
        return a.obtainAcronym();
    }
    public String descriptionToString(Description d){
        return d.getDescription();
    }



//package com.example.eCafetaria.application.dishtype;
//
//import com.example.eCafetaria.domain.dishtype.Acronym;
//import com.example.eCafetaria.domain.dishtype.Description;
//import com.example.eCafetaria.domain.dishtype.DishType;
//import org.springframework.stereotype.Component;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DishTypeMapper {

    public DishType toDishType(AcronymDTO acronym, CreateOrUpdateDishTypeDTO dto) {
        return new DishType(new Acronym(acronym.acronym), new Description(dto.getDescription()));
    }

    public List<DishTypeDTO> dishTypeDTOList(List<DishType> dishTypeList) {
        List<DishTypeDTO> dishTypeDTOList = new ArrayList<>();
        if (!dishTypeList.isEmpty()) {
            for (DishType dishType : dishTypeList) {
                dishTypeDTOList.add(toDto(dishType));
            }
        }
        return dishTypeDTOList;
    }

    public DishType update(DishType dishType, CreateOrUpdateDishTypeDTO dto) {
        dishType.setDescription(new Description(dto.getDescription()));
        return dishType;
    }
//
//    public DishTypeDTO toDTO(DishType dishType) {
//        return new DishTypeDTO(dishType.getAcronym().obtainAcronym(), dishType.getDescription().getDescriptiongetDescription());
//    }
}
