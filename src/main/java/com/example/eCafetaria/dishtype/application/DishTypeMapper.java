package com.example.eCafetaria.dishtype.application;

import com.example.eCafetaria.dishtype.domain.Acronym;
import com.example.eCafetaria.dishtype.domain.DishType;
import com.example.eCafetaria.dishtype.domain.Description;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


/**
 * The type Dish type mapper.
 */
@Mapper(componentModel = "spring")
public abstract class  DishTypeMapper {

    /**
     * To dto dish type dto.
     *
     * @param dishType the dish type
     * @return the dish type dto
     */
    public abstract DishTypeDTO toDto(DishType dishType);

    /**
     * To dish type dish type.
     *
     * @param acronym the acronym
     * @param dto     the dto
     * @return the dish type
     */
    public abstract DishType toDishType(DishTypeAcronymDTO acronym, DishTypeDescriptionDTO dto);

    /**
     * Dish type dto list iterable.
     *
     * @param dishTypeList the dish type list
     * @return the iterable
     */
    public abstract Iterable<DishTypeDTO> dishTypeDTOList (Iterable<DishType> dishTypeList);

    /**
     * Update dish type.
     *
     * @param dishType the dish type
     * @param dto      the dto
     * @return the dish type
     */
    public abstract DishType update(@MappingTarget DishType dishType, DishTypeDescriptionDTO dto);


    /**
     * Acronym to string string.
     *
     * @param a the a
     * @return the string
     */
    public String acronymToString(Acronym a){
        return a.obtainAcronym();
    }

    /**
     * Description to string string.
     *
     * @param d the d
     * @return the string
     */
    public String descriptionToString(Description d){
        if(d==null){
            return "";
        }
        return d.getDescription();
    }

    /**
     * String to acronym acronym.
     *
     * @param a the a
     * @return the acronym
     */
    public Acronym stringToAcronym (String a){
        return new Acronym(a);
    }

    /**
     * String to description description.
     *
     * @param a the a
     * @return the description
     */
    public Description stringToDescription (String a){
        return new Description(a);
    }
}


//package com.example.eCafetaria.application.domain;
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

