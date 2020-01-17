package com.ui.util;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;

    void setWebDriver(WebDriver driver) {
        BasePage.driver = driver;
    }
}