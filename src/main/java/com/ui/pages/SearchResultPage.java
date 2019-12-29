package com.ui.pages;

import com.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchResultPage extends BasePage {

    //*********Constructor*********
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "/html/body")
    private WebElement pageContent;

    @FindBy(how = How.XPATH, using = "//div[@class=\"r\"]/a/h3")
    private List<WebElement> searchResultElements;

    @FindBy(how = How.XPATH, using = "//div[@class=\"r\"]/a/div/cite")
    private List<WebElement> fetchResultDomains;

    @FindBy(how = How.CSS, using = "[valign='top'] > td > a")
    private List<WebElement> pageNavigationElements; //except current page 1

    //*********Page Methods*********
    public SomePage ThanIClickNotAddLink(int linkNumber) {
        searchResultElements.get(linkNumber - 1).click();
        return new PageFactory().initElements(driver, SomePage.class);
    }

    public SearchResultPage ThanICheckSearchResultsPresent() {
        assertTrue(getSearchResultElements().
                size() > 0, "No search result found for searched text");
        return this;
    }

    public SearchResultPage AndVerifyExpectedDomainPresent(String expectedDomain, int pagesAmountForCheck) {
        List<String> actualDomains = fetchFirstPagesDomains(pagesAmountForCheck);
        actualDomains.stream()
                .filter(domain -> domain.contains(expectedDomain))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No related domain found for searched text." +
                        "\nExpected domain was: " + expectedDomain));
        return this;
    }

    //*********Methods*********
    private List<String> fetchFirstPagesDomains(int pageResultAmount) {
        int navigationElementsAmount = getPageNavigationElements().size();
        List<String> domains = new ArrayList<>();
        for (int i = 0; i < navigationElementsAmount; i++) {
            if (i > pageResultAmount)
                break;
            for (WebElement domain : collectPageDomains(i)) {
                domains.add(readText(domain));
            }
        }
        return domains;
    }

    private List<WebElement> getSearchResultElements() {
        return this.searchResultElements;
    }

    private List<WebElement> collectPageDomains(int pageNumber) {
        moveToSearchResultPage(pageNumber);
        return fetchCurrentPageDomains();
    }

    private List<WebElement> fetchCurrentPageDomains() {
        return this.fetchResultDomains;
    }

    private void moveToSearchResultPage(int pageNumber) {
        if (pageNumber > 1) {
            click(driver.findElement(By.cssSelector("[aria-label='Page " + pageNumber + "']")));
        }
    }

    public List<WebElement> getPageNavigationElements() {
        return this.pageNavigationElements;
    }
}