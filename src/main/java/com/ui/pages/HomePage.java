package com.ui.pages;

import com.ui.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    private String baseURL = "http://google.com";

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "/html/body")
    private WebElement pageContent;

    @FindBy(how = How.XPATH, using = "//input[@name='q']")
    private WebElement searchTextField;

    //*********Page Methods*********
    //Go to Homepage
    public HomePage GivenIAmAtHomePage() {
        driver.get(baseURL);
        return this;
    }

    //Go to SearchResultPage
    public SearchResultPage WhenISearchText(String text) {
        writeText(searchTextField, text);
        searchTextField.sendKeys(Keys.ENTER);
        return new PageFactory().initElements(driver, SearchResultPage.class);
    }
}