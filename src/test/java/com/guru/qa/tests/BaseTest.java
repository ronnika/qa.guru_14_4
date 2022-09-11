package com.guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    static String browserName = System.getProperty("browser_name", "chrome");
    static String browserVersion = System.getProperty("browser_version", "100.0");
    static String browserSize = System.getProperty("browser_size", "1920x1080");
    static String remote = System.getProperty("remote");

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = browserSize;
        Configuration.browser = browserName;
        Configuration.browserVersion = browserVersion;

        if (remote != null) {
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = "https://" + "user1:1234@" + remote;
        }

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (remote != null) {
            Attach.addVideo();
        }
    }

}
