package com.example.eCafetaria.domain.dishtype;

import com.example.eCafetaria.domain.dishtype.exceptions.InvalidLenghtForDescription;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DescriptionTest {


    @Test
    void Test_Description_Should_Not_Go_Beyond_2048() {
        //Arrange

        String testStringWith2049Characters = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer id nibh eget dolor efficitur faucibus. Nulla facilisi. Sed rhoncus sem et ante interdum, id pharetra neque varius. Sed sed orci non purus placerat aliquet a id justo. Donec eget tincidunt purus. Vestibulum in vestibulum nunc. Nullam vel ullamcorper mi. Donec fringilla malesuada dapibus. Sed iaculis elit non orci ultricies, nec varius est ultricies. Suspendisse porttitor auctor est, nec facilisis ante congue a. Morbi ultrices urna mauris, ac ultrices neque condimentum vel. Nullam id odio diam. Maecenas tincidunt ligula id ex tempus, vitae fermentum dolor feugiat. Curabitur dapibus est mi, eget tempus leo pharetra in. Vestibulum vehicula mauris nulla, a porttitor ex gravida at. Phasellus sit amet libero nec erat bibendum sollicitudin. Sed rutrum semper mauris non dapibus. Donec bibendum eros a rhoncus laoreet. Sed maximus, metus sit amet dictum aliquam, quam sem interdum sapien, vel tempus eros ex non turpis. Nam tincidunt nulla mauris, in aliquet justo ultricies a. Curabitur convallis mi nec sapien venenatis, id feugiat nulla sollicitudin. Curabitur non neque ac lorem tristique condimentum. Vestibulum vitae tortor ac nulla malesuada fermentum ac non mauris. Morbi vel placerat felis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla iaculis pretium aliquam. In ullamcorper luctus odio vitae placerat. Suspendisse et facilisis enim. Aliquam erat volutpat. Curabitur sit amet semper metus. In eu diam ut purus dictum iaculis ut eu odio. Nam et iaculis urna. Maecenas varius turpis eu risus euismod, eu rutrum lectus lobortis. Nam placerat semper tellus, vitae finibus ipsum. Sed in tempor arcu. Aliquam ullamcorper est in lobortis finibus. Donec ultrices posuere luctus. Sed et augue eu arcu sagittis scelerisque ut eget ex. Quisque in ex in sem porttitor malesuada. In hac habitasse platea dictumst. Sed ullamcorper fermentum risus sed aliquam. Sed sit amet pulvinar quam, nec rhoncus est. Etiam maximus augue in justo dignissim laoreet. Nullam consequat tellus quis dapibus gravida. In eleifend felis eu finibus ultrices. In eu lacus id sem ultricies placerat nec sed neque. Aenean auctor viverra elit nec tristique. Maecenas vel metus dolor. Suspendisse luctus purus ligula, sed viverra tellus aliquet sit amet. Nam laoreet, est in tincidunt pellentesque, quam ex feugiat dui, id viverra dolor lacus id mi. Morbi imperdiet, ligula vitae finibus varius, nibh nulla eleifend erat, a tempor nulla quam";
        Description descriptionTest = new Description(testStringWith2049Characters);
        DishType dishTypeTeste = new DishType();
        Assertions.assertThrows(InvalidLenghtForDescription.class, () -> {
            dishTypeTeste.setDescription(descriptionTest);
        });
    }

    @Test
    void est_Description_Should_Not_Go_Bellow_1() throws InvalidLenghtForDescription {
        //Arrange
        String testStringWith2049Characters = "L";

        //Act
        try {
            if (testStringWith2049Characters.length() > 1 || testStringWith2049Characters.length() < 2048) {
                Description test_description = new Description(testStringWith2049Characters);
            } else {
                throw new InvalidLenghtForDescription();
            }
        } catch (InvalidLenghtForDescription e) {
            String expectedMessage = "Invalid Length for 'Designation'. Has to be between 1 and 2048 characters!";
            String actualMessage = e.getMessage();
            Assertions.assertEquals(expectedMessage, actualMessage);
        }
    }

    @Test
    void Test_Description_Should_Create_Designation() throws InvalidLenghtForDescription {
        //Arrange
        String testStringWith2049Characters = "Lorem ipsum dolor sit amet";

            Assertions.assertDoesNotThrow(()->{      if (testStringWith2049Characters.length() > 1 || testStringWith2049Characters.length() < 2048) {
                Description test_description = new Description(testStringWith2049Characters);
            } else {
                throw new InvalidLenghtForDescription();
            };
        }, "An Exception was unexpectedly thrown!");
    }

    @Test
    void Test_Description_Should_Accept_Any_Character(){
        String input = "Test that it accepts any character: !#$%&/()=?*º~ª_-.:,;1234567890";
        Description description_test = new Description(input);
        Assertions.assertEquals(input,description_test.getDesignation());
    }

}