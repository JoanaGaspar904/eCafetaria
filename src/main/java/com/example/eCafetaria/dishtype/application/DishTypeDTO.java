package com.example.eCafetaria.dishtype.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "A complete dish type")
@AllArgsConstructor
public class DishTypeDTO {
    @Schema(description = "Dish type Identity")
    String acronym;
    String description;

}
