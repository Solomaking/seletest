package ui.tests;

import com.ui.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class SearchResultPageTest extends BaseTest {

    @Test
    public void testOpenedPageTitleContainsSearchText() {
        String textForSearch = "automation";

        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenISearchText(textForSearch)
                .ThanIClickNotAddLink(1)
                .VerifyTitleHasText(textForSearch);
    }
}