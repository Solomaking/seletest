package com.ui.pages;

import com.ui.BasePage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SomePage extends BasePage {
    //*********Constructor*********
    public SomePage(WebDriver driver) {
        super(driver);
    }

    //*********Page Methods*********
    public void VerifyTitleHasText(String textForSearch) {
        String actualPageTitle = driver.getTitle();
        assertTrue(actualPageTitle.toLowerCase().contains(textForSearch));
    }
}