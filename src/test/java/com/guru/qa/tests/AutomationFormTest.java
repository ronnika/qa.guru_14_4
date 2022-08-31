package com.guru.qa.tests;

import com.guru.qa.data.TestData;
import com.guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Registration form tests")
public class AutomationFormTest extends BaseTest {

    private TestData testData = new TestData();

    @Test
    @DisplayName("Fill form with correct data test")
    void fillFormTest() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        step("Open registration form", () -> {
            registrationFormPage.openForm();
        });
        step("Fill in registration form with data", () -> {
            registrationFormPage.fillForm(testData);
        });
        step("Check if modal results is equal to the data you filled", () -> {
            registrationFormPage.checkResults(testData);
        });
    }
}
