package com.guru.qa.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;

public class CheckBoxInput {
    private final String name;
    private final SelenideElement selector;

    public CheckBoxInput(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Set {this.name} checkboxes with {hobbies}")
    public void checkBoxes(String[] hobbies) {
        for (String hobby: hobbies){
            selector.$(byText(hobby)).click();
        }
    }
}
