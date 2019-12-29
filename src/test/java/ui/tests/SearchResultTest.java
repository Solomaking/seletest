package ui.tests;

import com.ui.pages.HomePage;
import com.ui.pages.SearchResultPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class SearchResultTest extends BaseTest {
    private HomePage searchPage = new HomePage(driver);
    private SearchResultPage resultPage = new SearchResultPage(driver);

    @Test
    public void testExpectedDomainPresent() throws InterruptedException {
        String textForSearch = "automation";
//        String expectedDomain = "test" + textForSearch + "day.com";
        String expectedDomain = "https://automated-testing.info";

        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenISearchText(textForSearch)
                .ThanICheckSearchResultsPresent()
                .AndVerifyExpectedDomainPresent(expectedDomain, 5);
    }
}