package neonTests;

import io.qameta.allure.*;
import listeners.AllureListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class Test_1002 extends BaseTest {

    @Test
    @Description("Validate open page")
    @Epic("Epic 10002: Load home page")
    @Feature("Feature 2002: Open home page ")
    @Story("Story 3002: Open homepage successfully")
    @Severity(SeverityLevel.BLOCKER)
    public void validateOpenUrl(){

        homePage.setSearchText("Selenium");
        homePage.searchButton();
        String url = resultsPage.getUrl();
        Assert.assertTrue(url.contains("Seleniummmmm"));
    }
}
