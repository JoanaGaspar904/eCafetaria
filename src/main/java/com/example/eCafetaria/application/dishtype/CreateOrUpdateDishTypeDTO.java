package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.dishtype.Designation;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrUpdateDishTypeDTO {
    String designation;
}
