package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.domain.dishtype.exceptions.NotASingleWord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DishTypeTest {

    @Test
    void Test_setAcronym_Not_A_Single_Word() throws NotASingleWord{
        String acronymToTest = "C R";
        String descriptionToTest = "carne";
        Assertions.assertThrows(NotASingleWord.class, () -> {
            new DishType(new Acronym(acronymToTest), new Description(descriptionToTest));
        });
    }

    @Test
    void Test_setAcronym_No_Special_Characters() {
        String acronymToTest = "C!R";
        String descriptionToTest = "carne";
        Assertions.assertThrows(NotASingleWord.class, () -> {
            new DishType(new Acronym(acronymToTest), new Description(descriptionToTest));
        });
    }
}