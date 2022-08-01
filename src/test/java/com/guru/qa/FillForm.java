package com.guru.qa;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FillForm {
    public static void fillFormWithData () {
        $("#firstName").setValue(TestData.firstName);
        $("#lastName").setValue(TestData.lastName);
        $("#userEmail").setValue(TestData.userEmail);
        $("#userNumber").setValue(TestData.userNumber);
        $(byText(TestData.gender)).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue(TestData.year);
        $(".react-datepicker__month-select").selectOptionContainingText(TestData.month);
        $(".react-datepicker__day--0" + TestData.day).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText(TestData.hobby)).click();
        $("#uploadPicture").uploadFile(new File(TestData.picture));
        $("#currentAddress").setValue(TestData.currentAddress);
        $("#state input").setValue(TestData.state).pressEnter();
        $("#city input").setValue(TestData.city).pressEnter();
        $("#submit").click();
    }
}
