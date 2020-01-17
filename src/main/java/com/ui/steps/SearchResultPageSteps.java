package com.ui.steps;

import com.ui.pages.SearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SearchResultPageSteps {
    private SearchResultPage page = new SearchResultPage();

    @And("Click link {int} with result \\(not advertisement)")
    public void clickNotAddLink(int linkNumber) {
        page.clickNotAddLink(linkNumber);
    }

    @Then("Related results present")
    public void checkSearchResultsPresent() {
        page.checkSearchResultsPresent();
    }

    @And("My {string} is present on first {int} pages")
    public void verifyExpectedDomainPresent(String expectedDomain, int amountPages) {
        page.verifyExpectedDomainPresent(expectedDomain, amountPages);
    }


}
