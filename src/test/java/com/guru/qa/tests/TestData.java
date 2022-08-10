package com.guru.qa.tests;

public class TestData {
    public String
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
    public String[]
        hobbies = {"Music", "Reading"},
        subjects = {"English", "Arts"};

    public TestData() {}

    public TestData(String firstName, String lastName, String userEmail, String userNumber, String gender, String day, String month, String year, String pictureName, String currentAddress, String state, String city, String[] hobbies, String[] subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userNumber = userNumber;
        this.gender = gender;
        this.day = day;
        this.month = month;
        this.year = year;
        this.pictureName = pictureName;
        this.currentAddress = currentAddress;
        this.state = state;
        this.city = city;
        this.hobbies = hobbies;
        this.subjects = subjects;
    }
}
