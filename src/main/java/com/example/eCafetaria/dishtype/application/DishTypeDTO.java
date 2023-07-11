package com.example.eCafetaria.dishtype.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Dish type dto.
 */
@Data
@Schema(description = "A complete dish type")
@AllArgsConstructor
public class DishTypeDTO {
    /**
     * The Acronym.
     */
    @Schema(description = "Dish type Identity")
    String acronym;
    /**
     * The Description.
     */
    @Schema(description = "Dish type description")
    String description;

}
