package tests.android;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@Tag("Android")
public class WikipediaTests extends TestBase {
    String searchValue = "Appium";

    @Test
    @DisplayName("Check that query response is not empty")
    void successfulSearchAppiumTest() {
        mainScreen.openSearchPage();
        searchScreen.searchValue(searchValue)
                .checkResultsQuantity();
    }

    @Test
    @DisplayName("Open first result of query")
    void successfulSearchSelenideTest() {
        mainScreen.openSearchPage();
        searchScreen.searchValue(searchValue)
                .checkResultsQuantity();
        searchResultScreen.openFirstSearchResult()
                .checkErrorText();
    }
}
