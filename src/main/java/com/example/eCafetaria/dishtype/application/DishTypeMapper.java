package com.example.eCafetaria.dishtype.application;

import com.example.eCafetaria.dishtype.domain.Acronym;
import com.example.eCafetaria.dishtype.domain.DishType;
import com.example.eCafetaria.dishtype.domain.Description;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public abstract class DishTypeMapper {

    public abstract DishTypeDTO toDto(DishType dishType);
    public abstract DishType toDishType(AcronymDTO acronym, DishTypeDescriptionDTO dto);

    public abstract Iterable<DishTypeDTO> dishTypeDTOList (Iterable<DishType> dishTypeList);

    public abstract DishType update(@MappingTarget DishType dishType, DishTypeDescriptionDTO dto);


    public String acronymToString(Acronym a){
        return a.obtainAcronym();
    }
    public String descriptionToString(Description d){
        if(d==null){
            return "";
        }
        return d.getDescription();
    }
    public Acronym stringToAcronym (String a){
        return new Acronym(a);
    }
    public Description stringToDescription (String a){
        return new Description(a);
    }
//package com.example.eCafetaria.application.domain;
//
//import com.example.eCafetaria.domain.domain.Acronym;
//import com.example.eCafetaria.domain.domain.Description;
//import com.example.eCafetaria.domain.domain.DishType;
//import org.springframework.stereotype.Component;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DishTypeMapper {

//    public DishType toDishType(AcronymDTO acronym, CreateOrUpdateDishTypeDTO dto) {
//        return new DishType(new Acronym(acronym.acronym), new Description(dto.getDescription()));
//    }

//    public List<DishTypeDTO> dishTypeDTOList(List<DishType> dishTypeList) {
//        List<DishTypeDTO> dishTypeDTOList = new ArrayList<>();
//        if (!dishTypeList.isEmpty()) {
//            for (DishType dishType : dishTypeList) {
//                dishTypeDTOList.add(toDto(dishType));
//            }
//        }
//        return dishTypeDTOList;
//    }

//    public DishType update(DishType dishType, CreateOrUpdateDishTypeDTO dto) {
//        dishType.setDescription(new Description(dto.getDescription()));
//        return dishType;
//    }
//
//    public DishTypeDTO toDTO(DishType dishType) {
//        return new DishTypeDTO(dishType.getAcronym().obtainAcronym(), dishType.getDescription().getDescriptiongetDescription());
//    }
}
