package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.DishTypeDesignation;
import lombok.Data;

@Data
public class DishTypeDTO {
    String acronym;
    DishTypeDesignation designation;
}
