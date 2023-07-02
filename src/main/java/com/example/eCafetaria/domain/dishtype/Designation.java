package com.example.eCafetaria.domain.dishtype;

import lombok.Data;

@Data
public class Designation {
    String designation;

    private Designation(String designation) {
        this.designation = designation;
    }
}
