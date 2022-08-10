package com.guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DatePickerComponent {
    private SelenideElement
            dateOfBirthInput = $("#dateOfBirthInput"),
            yearInput = $(".react-datepicker__year-select"),
            monthInput = $(".react-datepicker__month-select");

    public DatePickerComponent setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        yearInput.selectOptionByValue(year);
        monthInput.selectOptionContainingText(month);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }
}
