package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.domain.dishtype.exceptions.NotASingleWord;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class AcronymTest {

    @BeforeEach
    void setUp() {
        System.out.println("AcronymTest for Single Word Started...");
    }
    @AfterEach
    void tearDown() {
        System.out.println("AcronymTest for Single Word Completed.");
    }
    @Test
    void AcronymTest_CreateAcronym_SingleWord() throws NotASingleWord {
        Acronym acronym = new Acronym("C R");
    }
    //void AcronymTest_UpdateAcronym_NoSpecialChars();
}