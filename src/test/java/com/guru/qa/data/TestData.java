package com.guru.qa.data;

import com.github.javafaker.Faker;
import com.guru.qa.utils.RandomData;

import java.util.Date;

public class TestData {
    RandomData randomData = new RandomData();
    private String
        firstName = randomData.getFirstName(),
        lastName = randomData.getLastName(),
        userEmail = randomData.getEmail(),
        userNumber = randomData.getNumber(),
        gender = randomData.getGender(),
        day = randomData.getDay(),
        month = randomData.getMonth(),
        year = randomData.getYear(),
        pictureName = randomData.getPictureName(),
        currentAddress = randomData.getCurrentAddress(),
        state = randomData.getState(),
        city = randomData.getCity();
    private String[]
        hobbies = randomData.getHobbies(), 
        subjects = randomData.getSubjects();

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
