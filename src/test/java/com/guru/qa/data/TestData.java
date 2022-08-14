package com.guru.qa.data;

import com.github.javafaker.Faker;
import com.guru.qa.utils.RandomData;

import java.util.Date;

public class TestData {
    RandomData data = new RandomData();

    private String
        firstName = data.getFirstName(),
        lastName = data.getLastName(),
        userEmail = data.getEmail(),
        userNumber = data.getNumber(),
        gender = data.getGender(),
        day = data.getDay(),
        month = data.getMonth(),
        year = data.getYear(),
        pictureName = data.getPictureName(),
        currentAddress = data.getCurrentAddress(),
        state = data.getState(),
        city = data.getCity();

    private String[]
        hobbies = data.getHobbies(),
        subjects = data.getSubjects();

    public TestData() {}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getPictureName() {
        return pictureName;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public String[] getSubjects() {
        return subjects;
    }
}
