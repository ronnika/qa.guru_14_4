package com.guru.qa.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;

public class RadioButton {
    private final String name;
    private final SelenideElement locator;

    public RadioButton(String name, SelenideElement locator) {
        this.name = name;
        this.locator = locator;
    }

    @Step("Select radio {val} of {this.name}")
    public void setValue(String val) {
        locator.$(byText(val)).click();
    }

    public String getName() {
        return name;
    }
}
