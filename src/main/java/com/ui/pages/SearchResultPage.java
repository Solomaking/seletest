package com.ui.pages;

import com.ui.util.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.testng.AssertJUnit.assertTrue;

public class SearchResultPage extends BasePage {

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "/html/body")
    private WebElement pageContent;

    @FindBy(how = How.XPATH, using = "//div[@class=\"r\"]/a/h3")
    private List<WebElement> searchResultElements;

    @FindBy(how = How.XPATH, using = "//div[@class=\"r\"]/a/div/cite")
    private List<WebElement> fetchResultDomains;

    @FindBy(how = How.CSS, using = "[valign='top'] > td > a")
    private List<WebElement> pageNavigationElements; //except current page 1

    //*********Initializing the Page Objects*********
    public SearchResultPage() {
        initElements(driver, this);
    }

    //*********Page Methods*********
    public void clickNotAddLink(int linkNumber) {
        searchResultElements.get(linkNumber - 1).click();
    }

    public void checkSearchResultsPresent() {
        assertTrue("No search result found for searched text",
                getSearchResultElements().size() > 0);
    }

    public void verifyExpectedDomainPresent(String expectedDomain, int pagesAmountForCheck) {
        boolean flag = false;
        int navigationElementsAmount = getPageNavigationElements().size();
        for (int i = 1; i <= navigationElementsAmount; i++) {
            if (i > pagesAmountForCheck)
                break;
            flag = checkCurrentPageDomains(i, expectedDomain);
            if (flag)
                break;
        }
        assertTrue("No related domain found for searched text." +
                "\nExpected domain was: " + expectedDomain, flag);
    }

    //*********Methods*********
    private List<WebElement> getSearchResultElements() {
        return this.searchResultElements;
    }

    private boolean checkCurrentPageDomains(int pageNumber, String expectedDomain) {
        moveToSearchResultPage(pageNumber);
        List<WebElement> domainElements = fetchCurrentPageDomains();
        List<String> domains = new ArrayList<>();
        for (WebElement domain : domainElements) {
            domains.add(domain.getText());
        }
        return (domains.stream()
                .anyMatch(domain -> domain.contains(expectedDomain)));
    }

    private List<WebElement> fetchCurrentPageDomains() {
        return this.fetchResultDomains;
    }

    private void moveToSearchResultPage(int pageNumber) {
        if (pageNumber > 1) {
            driver.findElement(By.cssSelector("[aria-label='Page " + pageNumber + "']")).click();
        }
    }

    private List<WebElement> getPageNavigationElements() {
        return this.pageNavigationElements;
    }
}