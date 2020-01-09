package com.ui.steps;

import com.ui.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageSteps {
    private HomePage homePage;

    @Given("I am at homepage")
    public void openHomePage() {
        homePage = new HomePage();
    }

    @When("I search {string}")
    public void searchText(String text) {
        homePage.searchText(text);
    }
}