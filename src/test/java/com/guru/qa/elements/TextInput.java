package com.guru.qa.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class TextInput {
    private final String name;
    private final SelenideElement selector;

    public TextInput(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Input {this.name}")
    public void setValue(String val) {
        selector.setValue(val);
    }
}
