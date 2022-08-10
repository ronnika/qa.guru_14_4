package com.guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import com.guru.qa.pages.components.AutoCompleteComponent;
import com.guru.qa.pages.components.DatePickerComponent;
import com.guru.qa.pages.components.ResultsModalComponent;
import com.guru.qa.pages.components.SelectComponent;
import com.guru.qa.tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadImageInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state input"),
            cityInput = $("#city input"),
            submitInput = $("#submit"),
            formWrapper = $(".practice-form-wrapper");
    private DatePickerComponent datePickerComponent = new DatePickerComponent();
    private ResultsModalComponent resultsModalComponent = new ResultsModalComponent();
    private AutoCompleteComponent autoCompleteComponent = new AutoCompleteComponent(subjectsInput);
    private SelectComponent stateSelectComponent = new SelectComponent(stateInput);
    private SelectComponent citySelectComponent = new SelectComponent(cityInput);
    private final static String TITLE_TEXT = "Student Registration Form";

    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationFormPage setNumber(String number) {
        numberInput.setValue(number);
        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationFormPage setDate(String day, String month, String year) {
        datePickerComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects(String[] subjects) {
        autoCompleteComponent.setValues(subjects);
        return this;
    }

    public RegistrationFormPage setHobbies(String[] hobbies) {
        for (String hobby: hobbies){
            $(byText(hobby)).click();
        }
        return this;
    }

    public RegistrationFormPage setImage(String imagePath) {
        uploadImageInput.uploadFromClasspath(imagePath);
        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        stateSelectComponent.setValue(state);
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        citySelectComponent.setValue(city);
        return this;
    }

    public RegistrationFormPage clickSubmit() {
        submitInput.click();
        return this;
    }

    public RegistrationFormPage openForm() {
        open("/automation-practice-form");
        formWrapper.shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public RegistrationFormPage fillForm (TestData data) {
        this.setFirstName(data.firstName)
                            .setLastName(data.lastName)
                            .setEmail(data.userEmail)
                            .setNumber(data.userNumber)
                            .setGender(data.gender)
                            .setDate(data.day, data.month, data.year)
                            .setSubjects(data.subjects)
                            .setHobbies(data.hobbies)
                            .setImage("img/" + data.pictureName)
                            .setAddress(data.currentAddress)
                            .setState(data.state)
                            .setCity(data.city)
                            .clickSubmit();
        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModalComponent.checkVisible();
        return this;
    }

    public RegistrationFormPage checkData(String key, String value) {
        resultsModalComponent.checkData(key, value);
        return this;
    }


    public RegistrationFormPage checkResults(TestData data) {
        this.checkResultsTableVisible()
                        .checkData("Student Name", data.firstName + " " + data.lastName)
                        .checkData("Student Email", data.userEmail)
                        .checkData("Gender", data.gender)
                        .checkData("Mobile", data.userNumber)
                        .checkData("Date of Birth", data.day + " " + data.month + "," + data.year)
                        .checkData("Subjects", String.join(", ", data.subjects))
                        .checkData("Hobbies", String.join(", ", data.hobbies))
                        .checkData("Picture", data.pictureName)
                        .checkData("Address", data.currentAddress)
                        .checkData("State and City",data.state + " " + data.city);
      return this;
    }
}
