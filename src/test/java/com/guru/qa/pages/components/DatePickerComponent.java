package com.guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DatePickerComponent {
    private final String name;
    private final SelenideElement selector;

    public DatePickerComponent(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Input date {day}.{month}.{year} to {this.name}")
    public DatePickerComponent setDate(String day, String month, String year) {
        selector.click();
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }
}
