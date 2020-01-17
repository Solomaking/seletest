package com.ui.pages;

import com.ui.util.BasePage;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.testng.AssertJUnit.assertTrue;

public class SomePage extends BasePage {

    public SomePage() {
        initElements(driver, this);
    }

    //*********Page Methods*********
    public void titleHasText(String textForSearch) {
        String actualPageTitle = driver.getTitle();
        assertTrue("Page title does not contain " + textForSearch, actualPageTitle.toLowerCase().contains(textForSearch));
    }
}