package com.guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class SelectComponent {
    private String name;
    private SelenideElement selector;

    public SelectComponent(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Input {value} to {this.name}")
    public SelectComponent setValue(String value) {
        selector.setValue(value).pressEnter();
        return this;
    }
}
