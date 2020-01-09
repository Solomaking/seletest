package com.ui.steps;

import com.ui.pages.SomePage;
import io.cucumber.java.en.Then;

public class SomePageSteps {
    private SomePage page = new SomePage();

    @Then("I can see the page with title contains {string}")
    public void checkPageTitle(String searchText) {
        page.titleHasText(searchText);
    }
}