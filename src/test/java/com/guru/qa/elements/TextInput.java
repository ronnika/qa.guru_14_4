package com.guru.qa.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class TextInput {
    private final String name;
    private final SelenideElement locator;

    public TextInput(String name, SelenideElement locator) {
        this.name = name;
        this.locator = locator;
    }

    @Step("Input {this.name}")
    public void setValue(String val) {
        locator.setValue(val);
    }

    public String getName() {
        return name;
    }
}
