package com.guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Form {
    static void fillDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__day--0" + day).click();
    }

    static void fillSubjectsAuto(String[] subjects) {
        for (String subject: subjects) {
            $("#subjectsInput").setValue(subject).pressEnter();
        }
    }

    static void fillHobbiesCheckBox(String[] hobbies) {
        for (String hobby: hobbies){
            $(byText(hobby)).click();
        }
    }

    public static void fillForm () {
        $("#firstName").setValue(TestData.firstName);
        $("#lastName").setValue(TestData.lastName);
        $("#userEmail").setValue(TestData.userEmail);
        $("#userNumber").setValue(TestData.userNumber);
        $(byText(TestData.gender)).click();
        fillDate(TestData.day, TestData.month, TestData.year);
        fillSubjectsAuto(TestData.subjects);
        fillHobbiesCheckBox(TestData.hobbies);
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
                                                                "," + TestData.year));
        $("tbody").shouldHave(Condition.text(TestData.currentAddress));
        $("tbody").shouldHave(Condition.text(String.join(",", TestData.hobbies)));
        $("tbody").shouldHave(Condition.text(String.join(",", TestData.subjects)));
        $("tbody").shouldHave(Condition.text(TestData.pictureName));
        $("tbody").shouldHave(Condition.text(TestData.state + " " + TestData.city));
    }
}
