package neonTests;

import io.qameta.allure.*;
import listeners.AllureListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class Test_1001 extends BaseTest {

    @Test
    @Description("Validate Search Term Appears in Results URL")
    @Epic("Epic 10001: Load proper URL")
    @Feature( "Feature 2001: Search ")
    @Story("Story 3001: If I search for a term, this one should be passed to URL ")
    @Severity(SeverityLevel.CRITICAL)

    public void googleSearch() {

        homePage.setSearchText("Automation Step by Step");
        homePage.searchButton();
        String url = resultsPage.getUrl();
        Assert.assertTrue(url.contains("Automation"));
    }
}
