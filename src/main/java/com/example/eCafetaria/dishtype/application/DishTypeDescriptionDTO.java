package com.example.eCafetaria.dishtype.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "A dish type description")
public class DishTypeDescriptionDTO {
    @Schema(description = "Dish type description")
    String description;
}
