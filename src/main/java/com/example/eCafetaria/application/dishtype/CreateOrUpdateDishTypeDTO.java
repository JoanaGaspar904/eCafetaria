package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.dishtype.Designation;
import lombok.Data;

@Data
public class CreateOrUpdateDishTypeDTO {
    Designation designation;
}
