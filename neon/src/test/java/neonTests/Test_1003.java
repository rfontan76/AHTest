package neonTests;

import io.qameta.allure.*;
import listeners.AllureListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class Test_1003 extends BaseTest {

    @Test
    @Description("Validate open page and validate the items count")
    @Epic("Epic 10003: All items are displayed in page")
    @Feature( "2003: HomePage Page has 1, 2, 3 items")
    @Story("3003: The home page loads at leaset 1 item")
    @Severity(SeverityLevel.CRITICAL)
    public void validateListofElementsHigherThanZero(){

        homePage.setSearchText("Rodrigo");
        homePage.searchButton();
        String url = resultsPage.getUrl();
        Assert.assertTrue(url.contains("Rodrigo"));


    }
}
