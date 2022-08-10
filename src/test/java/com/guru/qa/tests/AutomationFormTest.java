package com.guru.qa.tests;

import com.codeborne.selenide.Configuration;

import com.guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class AutomationFormTest {
    private RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    private TestData testData = new TestData();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openForm()
                            .fillForm(testData)
                            .checkResults(testData);
    }
}
