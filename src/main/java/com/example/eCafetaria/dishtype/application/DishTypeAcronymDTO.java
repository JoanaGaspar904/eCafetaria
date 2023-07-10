package com.example.eCafetaria.dishtype.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "A dish type acronym")
public class DishTypeAcronymDTO {
    @Schema(description ="Dish type acronym")
    public String acronym;
}
