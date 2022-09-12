package com.guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import com.guru.qa.elements.TextInput;
import com.guru.qa.pages.components.AutoCompleteComponent;
import com.guru.qa.pages.components.DatePickerComponent;
import com.guru.qa.pages.components.ResultsModalComponent;
import com.guru.qa.pages.components.SelectComponent;
import com.guru.qa.data.TestData;
import io.qameta.allure.Step;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import java.awt.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private SelenideElement

            uploadImageInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            submitInput = $("#submit"),
            formWrapper = $(".practice-form-wrapper");

    private TextInput firstNameInput = new TextInput("First name input", $("#firstName"));
    private TextInput lastNameInput = new TextInput("Last name input", $("#lastName"));
    private TextInput emailInput = new TextInput("Email input", $("#userEmail"));
    private TextInput numberInput = new TextInput("User number input", $("#userNumber"));

    private DatePickerComponent datePickerComponent = new DatePickerComponent();
    private ResultsModalComponent resultsModalComponent = new ResultsModalComponent();
    private AutoCompleteComponent autoCompleteComponent = new AutoCompleteComponent($("#subjectsInput"));
    private SelectComponent stateSelectComponent = new SelectComponent($("#state input"));
    private SelectComponent citySelectComponent = new SelectComponent($("#city input"));



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
        this.setFirstName(data.getFirstName())
                            .setLastName(data.getLastName())
                            .setEmail(data.getUserEmail())
                            .setNumber(data.getUserNumber())
                            .setGender(data.getGender())
                            .setDate(data.getDay(), data.getMonth(), data.getYear())
                            .setSubjects(data.getSubjects())
                            .setHobbies(data.getHobbies())
                            .setImage("img/" + data.getPictureName())
                            .setAddress(data.getCurrentAddress())
                            .setState(data.getState())
                            .setCity(data.getCity())
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
                .checkData("Student Name", data.getFirstName() + " " + data.getLastName())
                .checkData("Student Email", data.getUserEmail())
                .checkData("Gender", data.getGender())
                .checkData("Mobile", data.getUserNumber())
                .checkData("Date of Birth", data.getDay() + " " + data.getMonth() + "," + data.getYear())
                .checkData("Subjects", String.join(", ", data.getSubjects()))
                .checkData("Hobbies", String.join(", ", data.getHobbies()))
                .checkData("Picture", data.getPictureName())
                .checkData("Address", data.getCurrentAddress())
                .checkData("State and City", data.getState() + " " + data.getCity());
      return this;
    }
}
