package saucelabsTests;

import io.qameta.allure.*;
import listeners.AllureListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners({AllureListener.class})
public class Test_1001_SL extends SLabsBaseTest {

    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Test
    @Description("Validate Search Term Appears in Results URL")
    @Epic("Epic 10001: Load proper URL")
    @Feature( "Feature 2001: Search ")
    @Story("Story 3001: If I search for a term, this one should be passed to URL ")
    @Severity(SeverityLevel.CRITICAL)

    public void googleSearch() {

        //set your test case name so that it shows up in Sauce Labs
        capabilities.setCapability("name", "Test1");

        homePage.setSearchText("Automation Step by Step");
        homePage.searchButton();
        String url = resultsPage.getUrl();
        Boolean result = url.contains("Automation");
        assertTrue(result);

        /**
         * Here we teardown the driver session and send the results to Sauce Labs
         */
        if (result){
            ((JavascriptExecutor)driver).executeScript("sauce:job-result=passed");
        }
        else {
            ((JavascriptExecutor)driver).executeScript("sauce:job-result=failed");
        }


    }
}
