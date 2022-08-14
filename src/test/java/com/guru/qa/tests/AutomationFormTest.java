package com.guru.qa.tests;

import com.guru.qa.data.TestData;
import com.guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;


public class AutomationFormTest extends BaseTest {
    private RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    private TestData testData = new TestData();

    @Test
    void fillFormTest() {
        registrationFormPage.openForm()
                            .fillForm(testData)
                            .checkResults(testData);
    }
}
