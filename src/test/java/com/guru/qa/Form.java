package com.guru.qa;

import com.codeborne.selenide.Condition;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Form {
    public static void fillForm () {
        $("#firstName").setValue(TestData.firstName);
        $("#lastName").setValue(TestData.lastName);
        $("#userEmail").setValue(TestData.userEmail);
        $("#userNumber").setValue(TestData.userNumber);
        $(byText(TestData.gender)).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue(TestData.year);
        $(".react-datepicker__month-select").selectOptionContainingText(TestData.month);
        $(".react-datepicker__day--0" + TestData.day).click();
        for (int i = 0; i < TestData.subjects.length; i++) {
            $("#subjectsInput").setValue(TestData.subjects[i]).pressEnter();
        }
        for (int i = 0; i < TestData.hobbies.length; i++) {
            $(byText(TestData.hobbies[i])).click();
        }
        $("#uploadPicture").uploadFile(new File(TestData.picture));
        $("#currentAddress").setValue(TestData.currentAddress);
        $("#state input").setValue(TestData.state).pressEnter();
        $("#city input").setValue(TestData.city).pressEnter();
        $("#submit").click();
    }

    public static void checkResults() {
        $("tbody").shouldHave(Condition.text(TestData.firstName + " " + TestData.lastName));
        $("tbody").shouldHave(Condition.text(TestData.userEmail));
        $("tbody").shouldHave(Condition.text(TestData.gender));
        $("tbody").shouldHave(Condition.text(TestData.userNumber));
        $("tbody").shouldHave(Condition.text(TestData.day +
                                                                " " + TestData.month +
                                                                ", " + TestData.year));
        $("tbody").shouldHave(Condition.text(TestData.currentAddress));
        $("tbody").shouldHave(Condition.text(String.join(",", TestData.hobbies)));
        $("tbody").shouldHave(Condition.text(String.join(",", TestData.subjects)));
        $("tbody").shouldHave(Condition.text(TestData.pictureName));
        $("tbody").shouldHave(Condition.text(TestData.state + " " + TestData.city));






    }
}
