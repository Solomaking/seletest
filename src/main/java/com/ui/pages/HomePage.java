package com.ui.pages;

import com.ui.util.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage extends BasePage {

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "/html/body")
    private WebElement pageContent;

    @FindBy(how = How.XPATH, using = "//input[@name='q']")
    private WebElement searchTextField;

    //*********Initializing the Page Objects*********
    public HomePage() {
        initElements(driver, this);
    }

    //*********Page Methods*********
    public SearchResultPage searchText(String text) {
        searchTextField.sendKeys(text);
        searchTextField.sendKeys(Keys.ENTER);
        return new SearchResultPage();
    }
}