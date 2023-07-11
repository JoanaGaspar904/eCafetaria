package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.dishtype.domain.exceptions.NoSpecialCharacters;
import com.example.eCafetaria.dishtype.domain.exceptions.NotASingleWord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AcronymTest {
    @Test
    void Test_Acronym_CorrectAcronym_CRN() {
        String acronymToTest = "CRN";
        com.example.eCafetaria.dishtype.domain.Acronym actualAcronym = new com.example.eCafetaria.dishtype.domain.Acronym(acronymToTest);
        Assertions.assertEquals("CRN", actualAcronym.obtainAcronym());
    }

    
    @Test
    void Test_Acronym_Not_A_Single_Word() {
        String acronymToTest = "C R";
        Assertions.assertThrows(NotASingleWord.class, () -> {
            new com.example.eCafetaria.dishtype.domain.Acronym(acronymToTest);
        });
    }

    @Test
    void Test_Acronym_No_Special_Characters() {
        String acronymToTest = "C!R";
        Assertions.assertThrows(NoSpecialCharacters.class, () -> {
            new com.example.eCafetaria.dishtype.domain.Acronym(acronymToTest);
        });
    }

    @Test
    void Test_Acronym_Max_10_Characters() {
        String acronymToTest = "CARCARCARCAR";
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            new com.example.eCafetaria.dishtype.domain.Acronym(acronymToTest);
        });
    }
}