package com.guru.qa.tests;

public class TestData {
    private String
        firstName = "John",
        lastName = "Smith",
        userEmail = "john.smith@email.com",
        userNumber = "1234567890",
        gender = "Male",
        day = "11",
        month = "July",
        year = "1999",
        pictureName = "flowerdog.jpg",
        currentAddress = "boring st 1",
        state = "NCR",
        city = "Noida";
    private String[]
        hobbies = {"Music", "Reading"},
        subjects = {"English", "Arts"};

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
