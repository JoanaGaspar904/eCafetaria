package com.example.eCafetaria.application.dishtype;

import com.example.eCafetaria.domain.dishtype.Designation;
import lombok.Data;

@Data
public class DishTypeDTO {
    String acronym;
    String designation;

    public DishTypeDTO(String acronym, String designation) {
        this.acronym = acronym;
        this.designation = designation;
    }
}
