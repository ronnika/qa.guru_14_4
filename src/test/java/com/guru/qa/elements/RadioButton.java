package com.guru.qa.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RadioButton {
    private final String name;
    private final SelenideElement selector;

    public RadioButton(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Select radio {val} of {this.name}")
    public void setValue(String val) {
        $(byText(val)).click();
    }
}
