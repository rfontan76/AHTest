package applehealthapp;

import io.appium.java_client.AppiumDriver;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import pages.AppleHealthApp;
import utility.launchApp;

public class homepage {

    //Launching Application with Capabilities
    static AppiumDriver driver = launchApp.launchHealthApp();
    static AppleHealthApp healthHome = new AppleHealthApp(driver);

    @Test
    @Description("Validate the Home Page link")
    public static void verifyLinkIsDisplayed() {
        healthHome.isLinkIsVisible();
    }


    @Test
    @Description("Validate the Home Page Holder")
    public static void validateAppHolderIsDisplayed() {
        healthHome.isButtonDisplayed();
    }


}
