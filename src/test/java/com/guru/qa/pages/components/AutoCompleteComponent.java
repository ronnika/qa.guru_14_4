package com.guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class AutoCompleteComponent {
    private final String name;
    private final SelenideElement elementInput;

    public AutoCompleteComponent(String name, SelenideElement elementInput) {
        this.name = name;
        this.elementInput = elementInput;
    }

    @Step("Input {values} to {this.name}")
    public AutoCompleteComponent setValues(String[] values) {
        for (String value: values) {
            elementInput.setValue(value).pressEnter();
        }
        return this;
    }
}
