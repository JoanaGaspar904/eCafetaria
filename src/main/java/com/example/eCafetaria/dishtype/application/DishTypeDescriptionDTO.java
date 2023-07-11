package com.example.eCafetaria.dishtype.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;


/**
 * The type Dish type description dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishTypeDescriptionDTO {
    /**
     * The Description.
     */
    @Size(min = 0, max = 2048)
    String description;
}
