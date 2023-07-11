package com.example.eCafetaria.dishtype.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Dish type acronym dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishTypeAcronymDTO {
    /**
     * The Acronym.
     */
    public String acronym;
}
