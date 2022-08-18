package com.guru.qa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomData {
    private String
            day,
            month,
            year;

    private Faker faker = new Faker();

    private Random rand = new Random();

    public RandomData() {
        Date date = faker.date().birthday();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH);
        String[] dateArray = sdf.format(date).split("/");
        this.day = dateArray[0];
        this.month = dateArray[1];
        this.year = dateArray[2];
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getNumber() {
        return faker.numerify("##########");
    }

    public String getGender() {
        // TBD
        String[] gender = {"Male", "Female", "Other"};
        return gender[rand.nextInt(gender.length)];
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
        // TBD
        return "flowerdog.jpg";
    }

    public String getCurrentAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        // TBD
        return "NCR";
    }

    public String getCity() {
        // TBD
        String[] cities = {"Delhi", "Gurgaon", "Nioda"};
        return cities[rand.nextInt(cities.length - 1)];
    }

    public String[] getHobbies() {
        // TBD
        String[] hobbies = {"Sports", "Reading", "Music"};
        return hobbies;
    }

    public String[] getSubjects() {
        // TBD
        String[] subjects = {"Arts", "English", "Maths", "Economics"};
        return subjects;
    }

}
