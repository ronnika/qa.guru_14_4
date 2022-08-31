package com.guru.qa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public  class RandomData {
    private static String
            day,
            month,
            year;

    private static Faker faker = new Faker();

    private static Random rand = new Random();

    public RandomData() {
        Date date = faker.date().birthday();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH);
        String[] dateArray = sdf.format(date).split("/");
        this.day = dateArray[0];
        this.month = dateArray[1];
        this.year = dateArray[2];
    }

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getNumber() {
        return faker.numerify("##########");
    }

    public static String getGender() {
        // TBD
        String[] gender = {"Male", "Female", "Other"};
        return gender[rand.nextInt(gender.length)];
    }

    public static String getDay() {
        return day;
    }

    public static String getMonth() {
        return month;
    }

    public static String getYear() {
        return year;
    }

    public static String getPictureName() {
        // TBD
        return "flowerdog.jpg";
    }

    public static String getCurrentAddress() {
        return faker.address().fullAddress();
    }

    public static String getState() {
        // TBD
        return "NCR";
    }

    public static String getCity() {
        // TBD
        String[] cities = {"Delhi", "Gurgaon", "Nioda"};
        return cities[rand.nextInt(cities.length - 1)];
    }

    public static String[] getHobbies() {
        // TBD
        String[] hobbies = {"Sports", "Reading", "Music"};
        return hobbies;
    }

    public static String[] getSubjects() {
        // TBD
        String[] subjects = {"Arts", "English", "Maths", "Economics"};
        return subjects;
    }

}
