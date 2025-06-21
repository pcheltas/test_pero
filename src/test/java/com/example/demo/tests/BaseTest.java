package com.example.demo.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;

public abstract class BaseTest {

    @BeforeAll
    static void setUpAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--accept-lang=ru-RU");

        Configuration.browserCapabilities = options;
        Configuration.baseUrl = "https://vk.com";
        open("/");
    }

    @AfterEach
    void closeTabs() {
        while (driver().getWebDriver().getWindowHandles().size() > 1) {
            switchTo().window(1);
            closeWindow();
        }
        switchTo().window(0);
    }
}
