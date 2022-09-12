package com.guru.qa.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class FileUploadInput {
    private final String name;
    private final SelenideElement selector;

    public FileUploadInput(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Set {this.name} checkboxes with {vals}")
    public void uploadImage(String imagePath) {
        selector.uploadFromClasspath(imagePath);
    }

    public String getName() {
        return name;
    }
}
