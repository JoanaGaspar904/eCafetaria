package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.domain.dishtype.exceptions.NoSpecialCharacters;
import com.example.eCafetaria.domain.dishtype.exceptions.NotASingleWord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DishTypeTest {
    @Test
    void Test_Acronym_CorrectAcronym_CRN() {
        String acronymToTest = "CRN";
        Acronym actualAcronym = new Acronym(acronymToTest);
        Assertions.assertEquals("CRN", actualAcronym.obtainAcronym());
    }

    @Test
    void Test_Acronym_Not_A_Single_Word() {
        String acronymToTest = "C R";
        Assertions.assertThrows(NotASingleWord.class, () -> {
            new Acronym(acronymToTest);
        });
    }

    @Test
    void Test_Acronym_No_Special_Characters() {
        String acronymToTest = "C!R";
        Assertions.assertThrows(NoSpecialCharacters.class, () -> {
            new Acronym(acronymToTest);
        });
    }

    @Test
    void Test_Acronym_Max_10_Characters() {
        String acronymToTest = "CARCARCARCAR";
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            new Acronym(acronymToTest);
        });
    }
}